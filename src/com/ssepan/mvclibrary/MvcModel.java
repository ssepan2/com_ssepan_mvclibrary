package com.ssepan.mvclibrary;

//import java.beans.*;
import java.io.*;//File
import java.nio.file.*;//Path
import java.util.*;
import java.util.logging.Level;
//import javax.swing.JComponent;
import com.ssepan.application.*;
import com.ssepan.utility.*;
import java.io.FileNotFoundException;
//NOTE:may reference libini4j-java
//import org.ini4j.*;//https://ourcodeworld.com/articles/read/839/how-to-read-parse-from-and-write-to-ini-files-easily-in-java
import org.json.simple.*;
import org.json.simple.parser.*;
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
    
    //public static String C_INI_FILE = "mvcmodel.ini";
    public static String C_JSON_FILE = "mvcmodel_%s.json";
    
    Boolean bForceNotifyField= false;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MvcModel()
    {
        //call ctor() in base
        super();
                
    }
    // </editor-fold>
    
    
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


    // <editor-fold defaultstate="collapsed" desc="JSON IO">
    public static Boolean WriteJson
    (
        String filepath,
        MvcModel model
    ) 
        //throws FileNotFoundException, IOException
    {
        try {
            //Ini ini = new Ini(new File(filepath));
            JSONObject json = new JSONObject();

            json.put("SomeStringField", model.getSomeStringField());
            json.put("SomeIntegerField", model.getSomeIntegerField());
            json.put("SomeBooleanField", model.isSomeBooleanField());
            
            FileWriter file = new FileWriter(filepath);//Key in filename instead of inside file
            file.write(json.toJSONString()); 
            file.flush();
        } catch(Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            
        }

        return true;
    }
    
    public static Boolean ReadJson
    (
        String filepath,
        MvcModel model
    ) 
        //throws FileNotFoundException, IOException
    {
        try {
            //Ini ini = new Ini(new File(filepath));
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filepath);//Key in filename instead of inside file
            JSONObject json;// = new JSONObject();

            json = (JSONObject)jsonParser.parse(reader);
            
            String someString = (String)json.get("SomeStringField");//json.get(model.getKey(), "SomeStringField");
            Integer someInteger = (Integer)json.get("SomeIntegerField");//json.get(model.getKey(), "SomeIntegerField", Integer.class);
            Boolean someBoolean = (Boolean)json.get("SomeBooleanField");//json.get(model.getKey(), "SomeBooleanField", Boolean.class);

            //model Key is already set
            model.setSomeStringField(someString);
            model.setSomeIntegerField(someInteger);
            model.setSomeBooleanField(someBoolean);
        } catch (Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            
        }
        
        return true;
    }
     //</editor-fold>
  
  
//    // <editor-fold defaultstate="collapsed" desc="INI IO">
//    public static Boolean WriteIni
//    (
//        String filepath,
//        MvcModel model
//    ) 
//        //throws FileNotFoundException, IOException
//    {
//        try {
//            Ini ini = new Ini(new File(filepath));
//
//            ini.put(model.getKey(), "SomeStringField", model.getSomeStringField());
//            ini.put(model.getKey(), "SomeIntegerField", model.getSomeIntegerField());
//            ini.put(model.getKey(), "SomeBooleanField", model.isSomeBooleanField());
//            ini.store();
//        } catch(Exception ex) {
//            //sErrorMessage=ex.getMessage();
//            Log.write(ex,Level.ALL);
//        } finally {
//            
//        }
//
//        return true;
//    }
    
//    public static Boolean ReadIni
//    (
//        String filepath,
//        MvcModel model
//    ) 
//        //throws FileNotFoundException, IOException
//    {
//        try {
//            Ini ini = new Ini(new File(filepath));
//
//            String someString = ini.get(model.getKey(), "SomeStringField");
//            Integer someInteger = ini.get(model.getKey(), "SomeIntegerField", Integer.class);
//            Boolean someBoolean = ini.get(model.getKey(), "SomeBooleanField", Boolean.class);
//
//            //model Key is already set
//            model.setSomeStringField(someString);
//            model.setSomeIntegerField(someInteger);
//            model.setSomeBooleanField(someBoolean);
//        } catch (Exception ex) {
//            //sErrorMessage=ex.getMessage();
//            Log.write(ex,Level.ALL);
//        } finally {
//            
//        }
//        
//        return true;
//    }
    // </editor-fold>
  
// </editor-fold>
    
}
