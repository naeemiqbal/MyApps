Ext.define('BISM.view.misc.Two', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.two',
    items: [
        {xtype: 'textfield', fieldLabel: 'Name', regex: /\w{2}\s\w{2}/, regexText: 'Enter First & Last Name '},
        {xtype: 'textfield', fieldLabel: 'Email', vtype: 'email'},
        {xtype: 'numberfield', fieldLabel: 'Age', minValue: 0, maxValue: 125},
        {xtype: 'combobox', fieldLabel: 'Race'},
        {xtype: 'displayfield', fieldLabel: 'Display field', value: 'Story'},
        {xtype: 'datefield', fieldLabel: 'DOB 521'},
        {xtype: 'timefield', vtype: 'time', fieldLabel: "Taam", increment: 1}
        
    ],
    initComponent: function(){
        this.callParent(arguments);
    //    alert("in initComponent");
        
    },
    
    afterRender: function(){
      //  alert("nmi after render2 ");
        this.callParent(arguments);      
    },
    
    destroy: function () {
        this.callParent(arguments);
        alert("nmi TWO destroy  in the class");
    }    
});