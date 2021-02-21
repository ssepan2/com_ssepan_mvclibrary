package com.ssepan.mvclibrary;

import java.beans.*;
//import java.io.*;
//import javax.swing.JComponent;
import com.ssepan.application.*;
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
        return someStringField;
    }
    public void setSomeStringField(String value)// throws PropertyVetoException
    {
        someStringFieldOld = someStringField;
        //vetoableChangeSupport.fireVetoableChange("someStringField", someStringFieldOld, value);
        someStringField = value;
        propertyChangeSupport.firePropertyChange("someStringField", someStringField, value);
        setDirty(true);
    }
    
    private Integer someIntegerFieldOld;
    private Integer someIntegerField;
    public Integer getSomeIntegerField()
    {
        return someIntegerField;
    }
    public void setSomeIntegerField(Integer value)//        throws PropertyVetoException
    {
        someIntegerFieldOld = someIntegerField;
        //vetoableChangeSupport.fireVetoableChange("someIntegerField", someIntegerFieldOld, value);
        someIntegerField = value;
        propertyChangeSupport.firePropertyChange("someIntegerField", someIntegerField, value);
        setDirty(true);
    }

    private Boolean someBooleanFieldOld;
    private Boolean someBooleanField;
    public Boolean isSomeBooleanField()
    {
        return someBooleanField;
    }
    public void setSomeBooleanField(Boolean value)// throws PropertyVetoException
    {
        someBooleanFieldOld = someBooleanField;
        //vetoableChangeSupport.fireVetoableChange("someBooleanField", someBooleanFieldOld, value);
        someBooleanField = value;
        propertyChangeSupport.firePropertyChange("someBooleanField", someBooleanField, value);
        setDirty(true);
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
