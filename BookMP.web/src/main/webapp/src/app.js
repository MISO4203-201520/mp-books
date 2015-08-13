(function (ng) {

    var mainApp = ng.module('mainApp', [
        //'ngCrudMock',
        'authModule',
        'bookModule',
        'cartItemModule',
        'clientModule',
        'editorialModule',
        'ngRoute',
        'ngCrud'
    ]);

    mainApp.config(['$routeProvider', 'CrudTemplateURL', 'CrudCtrlAlias', function ($routeProvider, tplUrl, alias) {
            $routeProvider
                .when('/book', {
                    templateUrl: tplUrl,
                    controller: 'bookCtrl',
                    controllerAs: alias
                })
                .when('/client', {
                    templateUrl: tplUrl,
                    controller: 'clientCtrl',
                    controllerAs: alias
                })
                .when('/editorial', {
                    templateUrl: tplUrl,
                    controller: 'editorialCtrl',
                    controllerAs: alias
                })
                .otherwise('/');
        }]);
})(window.angular);
