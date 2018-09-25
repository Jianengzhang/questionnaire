/**
 * questionnaire
 * Created by 周颖仁 on 2018/9/18.
 */
var $table = $('#unitTable');
var tableDataUrl = '/unitManage/getUnit';


//单位添加按钮
var $addUnit = $('#addUnit');

var addUnitUrl = '/unitMange/addUnit'

$(function () {
    $table.bootstrapTable({
        url: tableDataUrl,
        method: 'get',
        dataType: 'json',
        cache: false,
        striped: true,
        undefinedText: '--',
        sortName: ['unitId','unitName', 'unitLevel', 'unitProvince', 'unitCity', 'unitAdress'],
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
        //detailView: true,详细列表
        //detailFormatter: detailFormatter,
        columns: [ {
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
                field: 'unitAdress',
                title: '单位地址'
        }]
    });
});



function refreshTable() {
    $table.bootstrapTable('refresh', {});
}

$addUnit.on('click',function(){
    layer.open({
        type:2,
        title:"单位添加",
        maxmin:true,
        //写成后台方法名吧，跳转地址
        content:"../../view/unit/unitManager.html",
        area: ['80%', '80%'],
        resize: true
    }) 
})


//需要确认是否影响页面内容加载？

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