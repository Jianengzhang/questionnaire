var $table = $('#unitTable');
var tableDataUrl = '/userManage/getAllUnit';

//单位添加按钮
var $addUnit = $('#addUnit');

var addUnitUrl = '/userManager/addUnit'

$(function () {
    $table.bootstrapTable({
        url: tableDataUrl,
        method: 'get',
        dataType: 'json',
        cache: false,
        striped: true,
        undefinedText: '--',
        sortName: ['unitName', 'unitLevel', 'unitProvince', 'unitCity', 'address'],
        sortOrder: 'desc',
        height: getHeight(),

        pagination: true,
        paginationLoop: true,
        pageList: [10, 20, 30],
        paginationPreText: '上一页',
        paginationNextText: '下一页',
        sidePagination: 'client',

        search: true,
        searchAlign: 'right',
        searchOnEnterKey: false,

        toolbar: '#tableToolbar',

        showColumns: true,
        showRefresh: true,
        showToggle: true,
        showPaginationSwitch: false,

        minimumCountColumns: 3,
        columns: [{
            checkbox: true,
            clickToSelect: true
        }, {
            field: 'unitName',
            title: '单位名称',
            sortable: true
        }, {
            field: 'unitLevel',
            title: '级别',
            sortable: true
        }, {
            field: 'unitProvince',
            title: '省份',
            sortable: true
        }, {
            field: 'unitCity',
            title: '城市',
            sortable: true
        },
            {
                field: 'address',
                title: '单位地址'
            }, {
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }]
    });
});

//单份处理
window.operateEvents = {

    //编辑用户角色
    'click .check': function (e, value, row, index) {
        layer.open({
            type: 2,
            title: '编辑内容',
            maxmin: true,
            content: '/unitManage/getUnit' +
            '&unitName = ' + row.unitName
            + '&unitLevel = ' + row.unitLevel
            + '?unitProvice = ' + row.unitProvince
            + '?unitCity = ' + row.unitCity
            + '?unitAddress' + row.Address,
            //传递用户账户以及真实姓名
            area: ['80%', '80%'],
            resize: true
        });
    },
};

function refreshTable() {
    $table.bootstrapTable('refresh', {});
}

//操作按钮格式设置
function operateFormatter(value, row, index) {
    var htmlElement = [];
    htmlElement.push('<a class="check btn btn-sm btn-link" href="javascript:void(0)" data-toggle="tooltip" title="编辑">',
        '<i class="glyphicon glyphicon-check"></i> 编辑',
        '</a>')
    return htmlElement.join('');
}

//单个操作确认弹窗
function layerConfirmSingle(confirmText, row, url) {
    layer.confirm(confirmText, {
            icon: 3,
            btn: ['确定', '取消']
        },
        function (index) {
            var ids = [];
            ids.push(row.account);
            accessServer(ids, url);
            layer.close(index);
        },
        function () {
            layer.msg('取消成功！');
        }
    )
}

//批量操作确认弹窗
function layerConfirmMulti(confirmText, ids, url) {
    layer.confirm(confirmText, {
            icon: 3,
            btn: ['确定', '取消']
        },
        function (index) {
            accessServer(ids, url);
            layer.close(index);
        },
        function () {
            layer.msg('取消成功！');
        }
    );
}

/*检查是否选中*/
function checkIsSelectedOne(ids) {
    if (0 === ids.length) {
        layer.msg('还未选择操作!', {icon: 5});
        return false;
    }
    return true;
}

/**
 * 异步加载服务器
 * @param userAccountArray
 * @param url
 */
function accessServer(userAccountArray, url) {
    $.ajax({
        url: url,
        type: 'post',
        data: {userAccountArray: userAccountArray},
        dataType: 'text',
        traditional: true,
        success: function (data) {
            analyzeResponse(data, url, userAccountArray);
        },
        error: function () {
            layer.msg('操作失败，出现点问题，刷新看看？', {icon: 2});
        }
    });
    return true;
}

/**
 * 解析回复数据包
 * @param data
 * @param url
 * @param accounts
 */
function analyzeResponse(data, url, accounts) {
    var responsePkt = JSON.parse(data);
    if (responsePkt.code === 200) {
        switch (url) {
            case deleteUserAccountUrl://永久删除账户
                if (responsePkt.code === 200) {
                    var failDeleteAccounts = responsePkt.data;
                    if (failDeleteAccounts.length <= 0) {
                        $table.bootstrapTable('remove', {
                            field: 'account',
                            values: accounts
                        });
                        layer.msg('已经永久删除！', {icon: 1});
                    } else {
                        for (var i = 0; i < failDeleteAccounts.length; i++) {
                            removeByValue(accounts, failDeleteAccounts[i]);
                        }
                        $table.bootstrapTable('remove', {
                            field: 'account',
                            values: accounts
                        });
                        layer.msg('已经永久删除' + accounts.length + '个账户\n\n！'
                            + '其中账户：' + failDeleteAccounts + '删除存在系统隐患，可以试试禁用账户!',
                            {icon: 1});
                    }
                }
                dealGlobalError(responsePkt);
                break;
            case enableUserAccountUrl://启用用户账户
                if (responsePkt.code === 200) {
                    layer.msg('已经启用账户！', {icon: 1});
                    //刷新表格数据
                    $table.bootstrapTable('refresh', {});
                }
                break;
            case disableUserAccountUrl://禁用用户账户
                if (responsePkt.code === 200) {
                    layer.msg('已经禁用账户！', {icon: 1});
                    //刷新表格数据
                    $table.bootstrapTable('refresh', {});
                }
                break;
            default:
                return;
        }
    }
}

/**
 * 删除 arr 数组中 存在 val 值的元素
 * @param arr
 * @param val
 */
function removeByValue(arr, val) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] === val) {
            arr.splice(i, 1);
            break;
        }
    }
}

//获取批量选中的id
function getIdSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.account;
    });
}

//获取屏幕高度
function getHeight() {
    return $(window).height() - $('.panel-body').outerHeight(true);
}