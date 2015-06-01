Ext.define('BISM.view.parts.Edit', {
    extend: 'Ext.window.Window',
    alias: 'widget.partsedit',
    title: 'Edit a part',
    requires: 'Ext.form.Panel',
    layout: 'fit',
    autoShow: true,
    width: 400,
    modal: true,
    initComponent: function () {
        this.items = [
            {
                xtype: 'form',
                items: [
                    {
                        xtype: 'numberfield',
                        name: 'partid',
                        fieldLabel: 'Part ID',
                        allowBlank: false
                    },
                    {
                        xtype: 'textfield',
                        name: 'partdesc',
                        fieldLabel: 'Description',
                        allowBlank: false
                    },
                    {
                        xtype: 'datefield',
                        name: 'productiondate',
                        fieldLabel: 'Date of Birth'
                    }
                ]
            }
        ];
        this.buttons = [
            {
                text : 'Save',
                action: 'save'
            },
            {
                text: 'Close',
                scope : this,
                //handler : function() { this.close();}
                handler: this.close
            }
        ];
        this.callParent(arguments);
    }


});