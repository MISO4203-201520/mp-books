(function (ng) {
    var mod = ng.module('authModule');

    mod.service('authUtils', ['$cookies', function ($cookies) {
            this.isAuthenticated = function () {
                return !!$cookies.get('cookie');
            };
        }]);
})(window.angular);
