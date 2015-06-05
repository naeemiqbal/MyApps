Ext.define('BISM.controller.Parts', {
    extend: 'Ext.app.Controller',
    stores: 'Parts@BISM.store',
    models: 'Part@BISM.model',
    //views: ['List@BISM.view.parts', 'Edit@BISM.view.parts'],
    //refs: [{ref: 'partsPanel', selector: 'panel'}],
    init: function () {
        this.control({' partsedit button[action=save]': {click: this.updatePart}});
        this.control({' partslist': {itemdblclick: this.editPart}});
        this.control({' partslist button[action=add]': {click: this.addPart}});
        this.control({' partslist button[action=delete]': {click: this.deletePart}});
        this.control({' partslist button[action=update]': {click: this.updatePart2}});
        this.control({' twobutton[action=opentwo]': {click: this.openTwo}});
        this.control({'button[action=openone]': {click: this.openOne}});
    },
    addPart: function (button)
    {
        var grid = button.up('partslist'),
                editw = Ext.create('BISM.view.parts.Edit', {mygrid: grid});
        editw.show();
    },
    updatePart2: function (button)
    {
        var grid = button.up('partslist'),
                selectedRow = grid.getSelectionModel().getSelection(),
                store = grid.store,
                row;
        if (selectedRow.length > 0)
        {
            row = store.indexOf(selectedRow[0]);
            var editw = Ext.create('BISM.view.parts.Edit');
            editw.show();
            editw.down('form').loadRecord(store.getAt(row));
        }
        else
            Ext.Msg.show({title: 'Parts Grid', msg: 'Select a record to update!',
                buttons: Ext.Msg.OK, fn: function (btn) {
                    if (btn === 'ok') {
                        debugger;
                        btn.window.close();
                    }
                }
            });
    },
    deletePart: function (button)
    {
        var grid = button.up('partslist'),
                selectedRow = grid.getSelectionModel().getSelection(),
                store = grid.store,
                row;
        if (selectedRow.length > 0)
        {
            row = store.indexOf(selectedRow[0]);
            grid.store.removeAt(row);
            store.save();
        }
        else
            Ext.Msg.show({title: 'Parts Grid', msg: 'Select a record to delete!',
                buttons: Ext.Msg.OK, fn: function (btn) {
                }
            });
    },
    editPart: function (grid, record) {
        var editw = Ext.create('BISM.view.parts.Edit', {singleton: true});
        editw.show();
        editw.down('form').loadRecord(record);
    },
    updatePart: function (button) {
        var win = button.up('window'),
                form = win.down('form'),
                record = form.getRecord(),
                values = form.getValues(),
                update = record || false;

        if (!update) {
            var grid = button.up('window').mygrid,
                    store = grid.getStore();
            store.add(values);
            store.save();
        }
        else
        {
            record.set(values);
        }
        win.close();
    },
    openTwo: function (btn) {
        var center = btn.up().up().down('#mainpage'),
                curr = center.down(),
                two = Ext.create('BISM.view.misc.Two');
        center.remove(curr);
        center.add(two);
        btn.up().down('#b_partslist').enable();
        curr.destroy();
        delete curr;

    },
    openOne: function (btn) {
        var center = btn.up().up().down('#mainpage'),
                curr = center.down(),
                //two = Ext.create('nmi', {xtype: 'nmilist'});
                one = Ext.create('BISM.view.parts.List');
        center.remove(curr);
        center.add(one);
        curr.destroy();
    }
});