(function(ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', '$location', function(CrudCreator, $scope, svc, model, $location) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'Shopping Cart');
            var self = this;
            this.newFetchRecords = function() {
                this.fetchRecords().then(function() {
                    self.calcTotal();
                });
            };
            this.newFetchRecords();
            $scope.ctrlerror = {status: false};
            this.readOnly = true;
            $scope.lastQuantity = 0;
            $scope.total = 0;

            this.recordActions = [{
                    name: 'Delete',
                    displayName: ' ',
                    icon: 'trash',
                    class: 'primary',
                    fn: function(record) {
                        return svc.deleteRecord(record).then(function() {
                            self.newFetchRecords();
                        });
                    },
                    show: function() {
                        return true;
                    }
                }];

            this.calcTotal = function() {
                $scope.total = 0;
                for (var i = 0; i < $scope.records.length; i++) {
                    $scope.total += $scope.records[i].product.price * $scope.records[i].quantity;
                }
            };

            $scope.goToGallery = function() {
                $location.path('/catalog');
            };
            $scope.verify = function(quantity) {
                $scope.lastQuantity = quantity;
            };//guarda la cantidad anterior

            $scope.postVerify = function(quantity) {
                var patron = /^\d*$/; //^[0-9]{3}$
                if (patron.test(quantity) && quantity > 0) {
                    self.calcTotal();
                } else {
                    $scope.ctrlerror = {status: true, type: "danger", msg: "You must enter a valid quantity"};
                    $scope.currentRecord = $scope.lastQuantity;
                }
            };//Realiza la validacion de la nueva cantidad asignada.
            $scope.checkout = function() {
                $scope.ctrlerror = {status: true, type: "warning", msg: "Not implemented yet"};
            };

        }]);

})(window.angular);
