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
        
        //TODO:init fields
      setSomeStringField("");
      setSomeIntegerField(0);
      setSomeBooleanField(false);
        
    }
    // </editor-fold>
    
    final String C_XML_FILE = "SomeXml.xml";
    
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
    //Note: "Default serialization will not serialize 'transient' and 'static' fields."

    private String someStringFieldOld;
    private String someStringField;
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
    
    private Integer someIntegerFieldOld;
    private Integer someIntegerField;
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

    private Boolean someBooleanFieldOld;
    private Boolean someBooleanField;
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

    // <editor-fold defaultstate="collapsed" desc="XML IO">
//    public static void Write
//    (
//        String filepath,
//        MvcModel model
//    ) 
//        throws FileNotFoundException
//    {
//        try 
//        (
//            XMLEncoder encoder = new XMLEncoder
//            (
//                new BufferedOutputStream
//                (
//                    new FileOutputStream(filepath)//"Beanarchive.xml"
//                )
//            )
//        )
//        { 
//            encoder.writeObject(model);
//        }
//    }
//    
//    public static MvcModel Read
//    (
//        String filepath
//    ) 
//        throws FileNotFoundException
//    {
//        MvcModel returnValue;
//        try 
//        (
//            XMLDecoder decoder = new XMLDecoder
//            (
//                new BufferedInputStream
//                (
//                    new FileInputStream(filepath)//"Beanarchive.xml"
//                )
//            )
//        )
//        {        
//            returnValue = (MvcModel)decoder.readObject();
//        }
//        
//        return returnValue;
//    }
//    // </editor-fold>
}
