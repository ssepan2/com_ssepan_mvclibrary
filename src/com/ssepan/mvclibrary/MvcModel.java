package com.ssepan.mvclibrary;

//import java.beans.*;
//import java.io.*;
import java.util.logging.Level;
//import javax.swing.JComponent;
import com.ssepan.application.*;
import com.ssepan.utility.*;
/**
 *
 * @author ssepan
 */
public class MvcModel
     extends ModelBase
{
    // <editor-fold defaultstate="collapsed" desc="Declarations">
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MvcModel()
    {
        //call ctor() in base
        super();
        
        //NOTE:do not init fields
        //someStringField="";
        //someIntegerField=0;
        //someBooleanField=false;
        
    }
    // </editor-fold>
    
    public static String C_XML_FILE = "SomeXml.xml";
    public static String C_INI_FILE = "SomeIni.ini";
    
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
    //Note: "Default serialization will not serialize 'transient' and 'static' fields."

    private String someStringFieldOld="";
    private String someStringField="";
    public String getSomeStringField()
    {
        String sStatusMessage="";
        String sErrorMessage="";
        String returnValue="";

        try {
            returnValue=someStringField;
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this
        }
        return returnValue;
    }
    public void setSomeStringField(String value)// throws PropertyVetoException
    {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            someStringFieldOld = someStringField;
            //vetoableChangeSupport.fireVetoableChange("someStringField", someStringFieldOld, value);
            someStringField = value;
            propertyChangeSupport.firePropertyChange("someStringField", someStringFieldOld, someStringField);
            setDirty(true);
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this

        }
    }
    
    private Integer someIntegerFieldOld=0;
    private Integer someIntegerField=0;
    public Integer getSomeIntegerField()
    {
        String sStatusMessage="";
        String sErrorMessage="";
        Integer returnValue=0;

        try {
            returnValue=someIntegerField;
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this
        }
        return returnValue;
    }
    public void setSomeIntegerField(Integer value)//        throws PropertyVetoException
    {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            someIntegerFieldOld = someIntegerField;
            //vetoableChangeSupport.fireVetoableChange("someIntegerField", someIntegerFieldOld, value);
            someIntegerField = value;
            propertyChangeSupport.firePropertyChange("someIntegerField", someIntegerFieldOld, someIntegerField);
            setDirty(true);
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this

        }
    }

    private Boolean someBooleanFieldOld=false;
    private Boolean someBooleanField=false;
    public Boolean isSomeBooleanField()
    {
        String sStatusMessage="";
        String sErrorMessage="";
        Boolean returnValue=false;

        try {
            returnValue=someBooleanField;
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this
        }
        return returnValue;
    }
    public void setSomeBooleanField(Boolean value)// throws PropertyVetoException
    {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            someBooleanFieldOld = someBooleanField;
            //vetoableChangeSupport.fireVetoableChange("someBooleanField", someBooleanFieldOld, value);
            someBooleanField = value;
            propertyChangeSupport.firePropertyChange("someBooleanField", someBooleanFieldOld, someBooleanField);
            setDirty(true);
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this

        }
    }
    // </editor-fold>
}
