$(function () {
    $('#userTable').bootstrapTable({
        columns: [{
            field: 'userId',
            title: '用户编码',
            visible: false
        }, {
            field: 'userName',
            title: '用户名称'
        }, {
            field: 'nickName',
            title: '昵称'
        }, {
            field: 'email',
            title: '邮箱'
        }, {
            field: 'phoneNum',
            title: '电话'
        }, {
            field: 'status',
            title: '状态'
        }, {
            field: 'createTime',
            title: '创建时间'
        }, {
            field: 'lastLoginTime',
            title: '最后登录时间'
        }]
    });
});

