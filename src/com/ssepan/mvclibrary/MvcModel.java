package com.ssepan.mvclibrary;

//import java.beans.*;
//import java.io.*;
import java.util.logging.Level;
//import javax.swing.JComponent;
import com.ssepan.application.*;
import com.ssepan.utility.*;
import java.io.FileNotFoundException;
/**
 *
 * @author ssepan
 */
public class MvcModel
     extends ModelBase
{
    // <editor-fold defaultstate="collapsed" desc="Declarations">
    public static String SOMESTRING_NEW = "";
    public static Integer SOMEINTEGER_NEW = 0;
    public static Boolean SOMEBOOLEAN_NEW = false;
    
    Boolean bForceNotifyField= false;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MvcModel()
    {
        //call ctor() in base
        super();
                
    }
    // </editor-fold>
    
    public static String C_XML_FILE = "SomeXml.xml";
    public static String C_INI_FILE = "SomeIni.ini";
    
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
    //Note: "Default serialization will not serialize 'transient' and 'static' fields."

    private String someStringFieldOld=SOMESTRING_NEW;
    private String someStringField=SOMESTRING_NEW;
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
    public void setSomeStringField(String value)
        {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            if ((someStringField != value) || bForceNotifyField) {
                someStringFieldOld = someStringField;
                someStringField = value;
                System.out.println(String.format("setSomeStringField: before='%s', after='%s'",someStringFieldOld,someStringField));
                notifyPropertyChanged("someStringField");
                setDirty(true);
            }
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this
        }
    }
    
    private Integer someIntegerFieldOld=SOMEINTEGER_NEW;
    private Integer someIntegerField=SOMEINTEGER_NEW;
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
    public void setSomeIntegerField(Integer value)
        {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            if ((someIntegerField != value) || bForceNotifyField) {
                someIntegerFieldOld = someIntegerField;
                someIntegerField = value;
                System.out.println(String.format("setSomeIntegerField: before='%s', after='%s'",someIntegerFieldOld.toString(),someIntegerField.toString()));
                notifyPropertyChanged("someIntegerField");
                setDirty(true);
            }
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this
        }
    }

    private Boolean someBooleanFieldOld=SOMEBOOLEAN_NEW;
    private Boolean someBooleanField=SOMEBOOLEAN_NEW;
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
    public void setSomeBooleanField(Boolean value)
        {
        String sStatusMessage="";
        String sErrorMessage="";

        try {
            if ((someBooleanField != value) || bForceNotifyField) {
                someBooleanFieldOld = someBooleanField;
                someBooleanField = value;
                System.out.println(String.format("setSomeBooleanField: before='%s', after='%s'",someBooleanFieldOld.toString(),someBooleanField.toString()));
                notifyPropertyChanged("someBooleanField");
                setDirty(true);
            }
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            //always do this

        }
    }
    // </editor-fold>
    

    // <editor-fold defaultstate="collapsed" desc="Methods">
  public void  refreshModel(Boolean bPreserveDirty) {
     String sErrorMessage="";
     Boolean bSaveDirty=false;
     String tempKey;
     String tempSomeString;
     Integer tempSomeInteger;
     Boolean tempSomeBoolean;
     
    try {
        bForceNotifyField = true;//will get past != check in property set

        bSaveDirty = isDirty();
        //setting these will set Dirty property...
        //NOTE:in Java PropertyChangeSupport, the event will only fire if old!=new
        tempKey=getKey();
        setKey(KEY_NEW);
        setKey(tempKey);
        
        tempSomeBoolean=isSomeBooleanField();
        setSomeBooleanField(SOMEBOOLEAN_NEW);
        setSomeBooleanField(tempSomeBoolean);
        
        tempSomeInteger=getSomeIntegerField();
        setSomeIntegerField(SOMEINTEGER_NEW);
        setSomeIntegerField(tempSomeInteger);
        
        tempSomeString=getSomeStringField();
        setSomeStringField(SOMESTRING_NEW);
        setSomeStringField(tempSomeString);

        //...so clear dirty flag after refreshing values
        if (bPreserveDirty) {
            setDirty(bSaveDirty); 
        } else {
            setDirty(false);
        }
    } catch (Exception ex) {
        //sErrorMessage=ex.getMessage();
        Log.write(ex,Level.ALL);
    } finally {
       bForceNotifyField = false;//don't want this on all the time
    };
  };


    // <editor-fold defaultstate="collapsed" desc="INI IO">
    public static Boolean WriteIni
    (
        String filepath,
        MvcModel model
    ) 
        throws FileNotFoundException
    {
//        Wini ini = new Wini(new File("C:\\Users\\sdkca\\Desktop\\myinifile.ini"));
//
//        ini.put("block_name", "property_name", "value");
//        ini.put("block_name", "property_name_2", 45.6);
//        ini.store();
        
        return true;
    }

    
    public static Boolean ReadIni
    (
        String filepath,
        MvcModel model
    ) 
        throws FileNotFoundException
    {
//        Wini ini = new Wini(new File("C:\\Users\\sdkca\\Desktop\\myinifile.ini"));
//        
//        int age = ini.get("owner", "age", int.class);
//        double height = ini.get("owner", "height", double.class);
//        String server = ini.get("database", "server");

        
            //NOTE:temp code
            model.setKey(model.getKey());
            model.setSomeBooleanField(!model.isSomeBooleanField());
            model.setSomeIntegerField(model.getSomeIntegerField()+1);
            model.setSomeStringField(model.getSomeStringField()+"y");
        
        return true;
    }

    // </editor-fold>
  
// </editor-fold>
    
}
