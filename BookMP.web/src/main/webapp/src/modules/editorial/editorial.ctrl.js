(function (ng) {
    var mod = ng.module('editorialModule');

    mod.controller('editorialCtrl', ['CrudCreator', '$scope', 'editorialService', 'editorialModel', function (CrudCreator, $scope, svc, model) {
            CrudCreator.extendController(this, svc, $scope, model, 'editorial', 'Editorial');
            this.fetchRecords();
        }]);
})(window.angular);
