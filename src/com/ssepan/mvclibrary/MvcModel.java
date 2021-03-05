package com.ssepan.mvclibrary;

//import java.beans.*;
import java.io.*;//File
//import java.nio.file.*;//Path
//import java.util.*;
import java.util.logging.Level;
//import javax.swing.JComponent;
import com.ssepan.application.*;
import com.ssepan.utility.*;
//import java.io.FileNotFoundException;
//NOTE:ini4j-0.5.1.jar, org-netbeans-libs-ini4j.jar need to be in dist/libs to run from command line
import org.ini4j.*;
//NOTE:json-simple-1.1.1.jar, org-netbeans-libs-json_simple.jar need to be in dist/libs to run from command line
import org.json.simple.*;
import org.json.simple.parser.*;
//NOTE:Dependency .jars of dependency project .jars not copied to main project dist/lib. 
//  Use selected answer @ https://stackoverflow.com/questions/9154122/how-can-i-have-netbeans-automatically-copy-3rd-party-jars-from-an-included-class by 'Gregory Peck'
//  Solves run from command line, but not run from IDE.

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
    
    public static final String C_XML_IO = "xml";//NOTE:xml related constants currently defined in base class
    public static final String C_INI_IO = "ini";
    public static final String C_JSON_IO = "json";
    public static String C_INI_FILE = "mvcmodel.ini";
    public static String C_JSON_FILE = "mvcmodel_%s.json";
    
    public static String IO_FORMAT="";
    
    Boolean bForceNotifyField= false;
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MvcModel()
    {
        //call ctor() in base
        super();
        
        IO_FORMAT = /*C_JSON_IO*/C_INI_IO/*C_XML_IO*/;                
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Properties">
    //Note: "Default serialization will not serialize 'transient' and 'static' fields."

    private String someStringFieldOld=SOMESTRING_NEW;
    private String someStringField=SOMESTRING_NEW;
    public String getSomeStringField()
    {
        //String sStatusMessage;//="";
        //String sErrorMessage;//="";
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
        //String sStatusMessage="";
        //String sErrorMessage="";

        try {
            if ((someStringField != value) || bForceNotifyField) {
                someStringFieldOld = someStringField;
                someStringField = value;
                //System.out.println(String.format("setSomeStringField: before='%s', after='%s'",someStringFieldOld,someStringField));
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
        //String sStatusMessage="";
        //String sErrorMessage="";
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
        //String sStatusMessage="";
        //String sErrorMessage="";

        try {
            if ((someIntegerField != value) || bForceNotifyField) {
                someIntegerFieldOld = someIntegerField;
                someIntegerField = value;
                //System.out.println(String.format("setSomeIntegerField: before='%s', after='%s'",someIntegerFieldOld.toString(),someIntegerField.toString()));
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
        //String sStatusMessage="";
        //String sErrorMessage="";
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
        //String sStatusMessage="";
        //String sErrorMessage="";

        try {
            if ((someBooleanField != value) || bForceNotifyField) {
                someBooleanFieldOld = someBooleanField;
                someBooleanField = value;
                //System.out.println(String.format("setSomeBooleanField: before='%s', after='%s'",someBooleanFieldOld.toString(),someBooleanField.toString()));
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
     //String sErrorMessage="";
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
//        System.out.println("refreshModel:"+tempSomeString);
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
    @SuppressWarnings("unchecked")
	public static Boolean WriteJson
    (
        String filepath,
        MvcModel model
    ) 
        //throws FileNotFoundException, IOException
    {
        Boolean returnValue=false;
        try {
            //Ini ini = new Ini(new File(filepath));
            JSONObject json = new JSONObject();

            json.put("SomeStringField", model.getSomeStringField());
            json.put("SomeIntegerField", model.getSomeIntegerField());
            json.put("SomeBooleanField", model.isSomeBooleanField());
            
            FileWriter file = new FileWriter(filepath);//Key in filename instead of inside file
            file.write(json.toJSONString()); 
            file.flush();
            file.close();
            
            returnValue=true;
        } catch(Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            
        }

        return returnValue;
    }
    
    public static MvcModel ReadJson
    (
        String filepath,
        MvcModel model
    ) 
        //throws FileNotFoundException, IOException
    {
        String sErrorMessage="";
        try {
            //Ini ini = new Ini(new File(filepath));
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(filepath);//Key in filename instead of inside file
            JSONObject json;// = new JSONObject();

            json = (JSONObject)jsonParser.parse(reader);
            
            String someString = (String)json.get("SomeStringField");//json.get(model.getKey(), "SomeStringField");
            //System.out.println("someString:"+someString);
            Integer someInteger = (int)(long)json.get("SomeIntegerField");//json.get(model.getKey(), "SomeIntegerField", Integer.class);
            //System.out.println("someInteger:"+someInteger);
            Boolean someBoolean = (Boolean)json.get("SomeBooleanField");//json.get(model.getKey(), "SomeBooleanField", Boolean.class);
            //System.out.println("someBoolean:"+someBoolean);

            //model Key is already set
            model.setSomeStringField(someString);
            model.setSomeIntegerField(someInteger);
            model.setSomeBooleanField(someBoolean);
            
        } catch (Exception ex) {
            model = null;
            sErrorMessage=ex.getMessage();
            System.out.println("ReadJson error:"+sErrorMessage);
            Log.write(ex,Level.ALL);
        } finally {
            
        }
        
        return model;
    }
     //</editor-fold>
  
    // <editor-fold defaultstate="collapsed" desc="INI IO">
    //Note:write fails if file not present
    public static Boolean WriteIni
    (
        String filepath,
        MvcModel model
    ) 
        throws FileNotFoundException, IOException
    {
        String sErrorMessage="";
        Boolean returnValue=false;
        try {
            Ini ini = new Ini(new File(filepath));

            ini.put(model.getKey(), "SomeStringField", model.getSomeStringField());
            ini.put(model.getKey(), "SomeIntegerField", model.getSomeIntegerField());
            ini.put(model.getKey(), "SomeBooleanField", model.isSomeBooleanField());
            ini.store();
            ini = null;

            returnValue=true;
        } catch(FileNotFoundException exFNF) {
            sErrorMessage=exFNF.getMessage();
            System.out.println(sErrorMessage);
            Log.write(exFNF,Level.ALL);
        } catch(IOException exIO) {
            sErrorMessage=exIO.getMessage();
            System.out.println(sErrorMessage);
            Log.write(exIO,Level.ALL);
        } catch(Exception ex) {
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            
        }

        return returnValue;
    }
    
    public static MvcModel ReadIni
    (
        String filepath,
        MvcModel model
    ) 
        //throws FileNotFoundException, IOException
    {
        try {
            Ini ini = new Ini(new File(filepath));

            String someString = ini.get(model.getKey(), "SomeStringField");
            Integer someInteger = ini.get(model.getKey(), "SomeIntegerField", Integer.class);
            Boolean someBoolean = ini.get(model.getKey(), "SomeBooleanField", Boolean.class);

            //model Key is already set
            model.setSomeStringField(someString);
            model.setSomeIntegerField(someInteger);
            model.setSomeBooleanField(someBoolean);


        } catch (Exception ex) {
            model=null;
            //sErrorMessage=ex.getMessage();
            Log.write(ex,Level.ALL);
        } finally {
            
        }
        
        return model;
    }
    // </editor-fold>
  
// </editor-fold>
    
}
