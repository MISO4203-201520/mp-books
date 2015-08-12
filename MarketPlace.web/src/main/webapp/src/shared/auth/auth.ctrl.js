(function (ng) {
    var mod = ng.module('authModule');

    mod.controller('authCtrl', ['authUtils', '$scope', function (authUtils, $scope) {
            $scope.isAuthenticated = authUtils.isAuthenticated();
        }]);
})(window.angular);
