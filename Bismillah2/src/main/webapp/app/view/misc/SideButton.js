Ext.define('BISM.view.misc.SideButton', {
    extend: 'Ext.button.Button',
    alias: 'widget.twobutton',
    width: '90',
    
    destroy : function(){
        alert("button destroy");
    }
})