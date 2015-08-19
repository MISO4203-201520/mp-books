(function (ng) {
    var mod = ng.module('cartItemModule');

    mod.controller('cartItemCtrl', ['CrudCreator', '$scope', 'cartItemService', 'cartItemModel', '$location', 'authService', function (CrudCreator, $scope, svc, model, $location, authSvc) {
            CrudCreator.extendController(this, svc, $scope, model, 'cartItem', 'My Shopping Cart');
            var self = this;
            this.newFetchRecords = function () {
                this.fetchRecords().then(function () {
                    self.calcTotal();
                });
            };
            this.newFetchRecords();
            this.readOnly = true;
            $scope.lastQuantity = 0;
            $scope.total = 0;

            this.recordActions = [{
                    name: 'Delete',
                    displayName: ' ',
                    icon: 'trash',
                    class: 'primary',
                    fn: function (record) {
                        return svc.deleteRecord(record).then(function () {
                            self.newFetchRecords();
                        });
                    },
                    show: function () {
                        return true;
                    }
                }];

            this.calcTotal = function () {
                $scope.total = 0;
                for (var i = 0; i < $scope.records.length; i++) {
                    $scope.total += $scope.records[i].product.price * $scope.records[i].quantity;
                }
            };

            $scope.goToGallery = function () {
                $location.path('/catalog');
            };
            $scope.verify = function (quantity) {
                $scope.lastQuantity = quantity;
            };//guarda la cantidad anterior

            $scope.postVerify = function (record) {
                var patron = /^\d*$/; //^[0-9]{3}$
                if (patron.test(record.quantity) && record.quantity > 0) {
                    self.calcTotal();
                } else {
                    self.showError("You must enter a valid quantity");
                    record.quantity = $scope.lastQuantity;
                    $scope.currentRecord = record;
                }
            };//Realiza la validacion de la nueva cantidad asignada.
            $scope.checkout = function () {
                self.showWarning("Not implemented yet");
            };
        }]);

})(window.angular);
