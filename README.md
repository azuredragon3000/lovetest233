package freemaker;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

import org.apache.commons.io.FileUtils;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;

public class MainActivity {

	private JFrame frame;
    private JTextField txtTextsize;
	private JTextField txtFont;
	private JTextField txtColor;
    public boolean check = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainActivity window = new MainActivity();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	/**
	 * Create the application.
	 */
	public MainActivity() {
		initialize();
	}

	private void generateFile(Map<String, Object> root,String template, String input, String output) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
		/* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle:        */
        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File(input));
        // Recommended settings for new projects:
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle:   */
        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate(template);
        /* Merge data-model with template */
        Writer out = new FileWriter(output);
        temp.process(root, out);
        out.close();
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
        
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 615, 340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnGenerateFilesJava = new JButton("Generate files Java");
		btnGenerateFilesJava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String infolder = "C:\\Users\\pch1hc\\Desktop\\eclipse\\templates\\";
				String outfolder = "C:\\Users\\pch1hc\\Desktop\\eclipse\\outputfile\\";
							
				try {				
                
				String t_inputview = "InputView.ftlh";
				String t_viewspec = "ObjectViewSpec.ftlh";
				ArrayList<View> views = new ArrayList<View>();
				int count =0;
				String t_objecttemplate = "ObjectViewSpecific.ftlh";
                Map<String, Object> root_view = new HashMap<String, Object>();
                Map<String, Object> root_view5 = new HashMap<String, Object>();
				ArrayList<String> ov = new ArrayList<String>();
				
                // view spec which define myself
                                ViewBEGINSpec specBEGIN = new ViewBEGINSpec();
                ViewBTSpec specBT = new ViewBTSpec();
                ViewSTARTSpec specSTART = new ViewSTARTSpec();
                ViewBTYSpec specBTY = new ViewBTYSpec();
                ViewTNTYSpec specTNTY = new ViewTNTYSpec();
				
				
				
                views.add(setViewC("BEGIN",count++,specBEGIN.root.get("products")));
                views.add(setViewC("BT",count++,specBT.root.get("products")));
                views.add(setViewC("START",count++,specSTART.root.get("products")));
                views.add(setViewC("BTY",count++,specBTY.root.get("products")));
                views.add(setViewC("TNTY",count++,specTNTY.root.get("products")));
                
                
				check = 
                        specBEGIN.check & 
                        specBT.check & 
                        specSTART.check & 
                        specBTY.check & 
                        specTNTY.check 
                ;
                
                ov.add("BTYViewHeart");
                ov.add("BTYViewNhaySoObject");
                ov.add("TNTYViewStarObject");
                
				ov.add("mEditText");
				
				root_view.put("views", views); 
                root_view.put("sview",ov);
				root_view5.put("sview", ov);
				root_view5.put("textsize",txtTextsize.getText());
				root_view5.put("font",txtFont.getText());
				root_view5.put("color",txtColor.getText());
                
				// generate object view
                generateF("BEGIN",t_inputview,t_viewspec,outfolder,infolder,specBEGIN);
                generateF("BT",t_inputview,t_viewspec,outfolder,infolder,specBT);
                generateF("START",t_inputview,t_viewspec,outfolder,infolder,specSTART);
                generateF("BTY",t_inputview,t_viewspec,outfolder,infolder,specBTY);
                generateF("TNTY",t_inputview,t_viewspec,outfolder,infolder,specTNTY);
                
				
                generateOBJECT(t_objecttemplate,"BTYViewHeart",outfolder,infolder);
                generateOBJECT(t_objecttemplate,"BTYViewNhaySoObject",outfolder,infolder);
                generateOBJECT(t_objecttemplate,"TNTYViewStarObject",outfolder,infolder);
                // object which will be define myself   
                
                
                // fix object
                generateFixObject("ChangeView",outfolder,infolder,root_view);
                generateFixObject("ConstantsControl",outfolder,infolder,root_view);
                generateFixObject("EngineView",outfolder,infolder,root_view);
                generateFixObject("ObjectView",outfolder,infolder,root_view5);
               	generateFixObject("mEditText",outfolder,infolder,root_view5);
				generateFixObject("RequestActivity",outfolder,infolder,root_view5);
                
                // done work
                System.out.println("Done!!");
				} catch (IOException | TemplateException e1) {
					e1.printStackTrace();
				}
			}

			private void generateFixObject(String st, String outfolder,String infolder, Map<String, Object> root_view) 
					throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
				String outfolder11 = outfolder+st+".java";
                String t_changeview = st+".ftlh";
                generateFile(root_view,t_changeview,infolder,outfolder11);		
			}

			private void generateOBJECT( String t_objecttemplate,
					String object, String outfolder, String infolder) 
							throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
				Map<String, Object> root_view1 = new HashMap<String, Object>();
				root_view1.put("ObjectViewSpecific", object);
				String outfolder14 = outfolder+object+".java";	
                generateFile(root_view1,t_objecttemplate,infolder,outfolder14);
				
			}

			private void generateF(String st, String t_inputview,String t_viewspec, String outfolder, String infolder, ViewSpec spec) 
					throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
				String outfolder1 = outfolder+"ObjectView"+st+"Spec.java";
                //ViewStartSpec specStart = new ViewStartSpec();
                setViewInput(st, spec.root);
                String outfolder6 = outfolder+"InputView"+st+".java";
                generateFile(spec.root,t_viewspec,infolder,outfolder1);
                generateFile(spec.root,t_inputview,infolder,outfolder6);
				
			}

			private void setViewInput(String st, Map<String, Object> root) {
				root.put("namefile1", "InputView"+st);
				root.put("cons", "VIEW_"+st);
				root.put("nview", st);
                root.put("namefile", "ObjectView"+st+"Spec");			
                root.put("nameimage", "objectview"+st.toLowerCase()+"spec");
			}

			private View setViewC(String view, int count,
					Object object) {
				View view0 = new View();
				view0.setCons("VIEW_"+view);
				view0.setCount(count);
				view0.setView(view);
				view0.setName("ObjectView"+view+"Spec");
				view0.setProduct(object);
				return view0;
			}

			
		});
		btnGenerateFilesJava.setBounds(28, 42, 177, 23);
		frame.getContentPane().add(btnGenerateFilesJava);
		
		JButton copyFile = new JButton("copyFile");
		copyFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            
            if(check){
                copyfile("C:\\Users\\pch1hc\\Desktop\\eclipse\\image",
						"C:\\Users\\pch1hc\\AndroidStudioProjects\\subHunter\\app\\src\\main\\res\\drawable");
				
				copyfile("C:\\Users\\pch1hc\\Desktop\\eclipse\\image",
						"C:\\Users\\pch1hc\\AndroidStudioProjects\\subHunter\\app\\src\\main\\res\\drawable-v24");
                        
                copyfile("C:\\Users\\pch1hc\\Desktop\\eclipse\\fixed",
						"C:\\Users\\pch1hc\\Desktop\\eclipse\\outputfile");
                        
				copyfile("C:\\Users\\pch1hc\\Desktop\\eclipse\\outputfile",
						"C:\\Users\\pch1hc\\AndroidStudioProjects\\subHunter\\app\\src\\main\\java\\com\\example\\main\\myView");
             }else{
                System.out.println("CANT COPY PLEASE CHECK IMAGE");
             }
		   }
		});
		copyFile.setBounds(28, 132, 177, 23);
		frame.getContentPane().add(copyFile);
        
        txtFont = new JTextField();
		txtFont.setText("viettay3.otf");
		txtFont.setBounds(372, 48, 86, 20);
		frame.getContentPane().add(txtFont);
		txtFont.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.setText("BLUE");
		txtColor.setBounds(372, 79, 86, 20);
		frame.getContentPane().add(txtColor);
		txtColor.setColumns(10);
		
		txtTextsize = new JTextField();
		txtTextsize.setText("20f");
		txtTextsize.setBounds(372, 110, 86, 20);
		frame.getContentPane().add(txtTextsize);
		txtTextsize.setColumns(10);
		
		JLabel lblFont = new JLabel("font");
		lblFont.setBounds(297, 51, 46, 14);
		frame.getContentPane().add(lblFont);
		
		JLabel lblColor = new JLabel("color");
		lblColor.setBounds(297, 82, 46, 14);
		frame.getContentPane().add(lblColor);
		
		JLabel lblSize = new JLabel("size");
		lblSize.setBounds(297, 113, 46, 14);
		frame.getContentPane().add(lblSize);
	}

	protected void copyfile(String from, String to) {
		try {
		    // source & destination directories
		    File src = new File(from);
		    File dest = new File(to);
		    // copy all files and folders from `src` to `dest`
		    FileUtils.copyDirectory(src, dest);
		    System.out.println("copy done");
		} catch (IOException ex) {
		    ex.printStackTrace();
		}
		
	}
}
