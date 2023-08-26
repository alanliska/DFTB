package cz.jh.dftb;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import uk.ac.cam.ch.wwmm.opsin.NameToStructure;
import uk.ac.cam.ch.wwmm.opsin.NameToStructureConfig;
import uk.ac.cam.ch.wwmm.opsin.OpsinResult;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import android.content.Context;
import android.util.Log;

import com.jrummyapps.android.shell.CommandResult;
import com.jrummyapps.android.shell.Shell;

public class MainActivity extends AppCompatActivity {

    private Handler handler = new Handler();
    private TextView ContentLabel;
    private EditText Content;
    private TextView CommandLabel;
    private EditText Command;
    Button openCommandfile;
    Button openIntCommandfile;
    Button saveCommandfile;
    Button saveExtCommandfile;
    private TextView InputLabel;
    private EditText InputFile;
    Button openInputfile;
    Button openIntInputfile;
    Button saveInputfile;
    Button saveExtInputfile;
    private TextView CoordLabel;
    private EditText CoordFile;
    Button openCoordfile;
    Button openIntCoordfile;
    Button saveCoordfile;
    Button saveExtCoordfile;
    Button generateXYZ;
    Button opsinXYZ;
    Button RunProgram;
    Button saveOutputfile;
    Button saveExtOutputfile;
    Button Highlight;
    Button Graph;
    Button About;
    Button License;
    private TextView textViewX;
    private TextView outputView;
    private EditText outputView2;
    private static final int READ_FILE6 = 6;
    private Uri documentUri6;
    private static final int READ_FILE26 = 26;
    private Uri documentUri26;
    private static final int CREATE_FILE20 = 20;
    private Uri documentUri20;
    private static final int CREATE_FILE01 = 1;
    private Uri documentUri0;
    private static final int CREATE_FILE21 = 21;
    private Uri documentUri21;
    private static final int READ_FILE60 = 60;
    private Uri documentUri60;
    private static final int CREATE_FILE200 = 200;
    private Uri documentUri200;
    Button manual_dftb;
    Button recipes_dftb;
    Button manual_modes;
    Button manual_openbabel;
    private static final int MY_PERMISSION_REQUEST_STORAGE = 1;

    static final String LOGTAG = "";
    static final int BUFSIZE = 5192;
    static final String ZIP_FILTER = "assets";

    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     *     Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     *     TextView.BufferType.SPANNABLE
     * );
     * </pre>
     * @param text Text that contains a substring to colorize
     * @param word0 The substring to colorize
     * @param word1 The substring to colorize
     * @param word2 The substring to colorize
     * @param word3 The substring to colorize
     * @param word4 The substring to colorize
     * @param word5 The substring to colorize
     * @param word6 The substring to colorize
     * @param word7 The substring to colorize
     * @param word8 The substring to colorize
     * @param word9 The substring to colorize
     * @param word10 The substring to colorize
     * @param word11 The substring to colorize
     * @param word12 The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    public static Spannable colorized(final String text, final String word0, final String word1, final String word2, final String word3, final String word4, final String word5, final String word6, final String word7, final String word8, final String word9, final String word10, final String word11, final String word12, final int argb) {
        final Spannable spannable = new SpannableString(text);
        int substringStart0=0;
        int substringStart1=0;
        int substringStart2=0;
        int substringStart3=0;
        int substringStart4=0;
        int substringStart5=0;
        int substringStart6=0;
        int substringStart7=0;
        int substringStart8=0;
        int substringStart9=0;
        int substringStart10=0;
        int substringStart11=0;
        int substringStart12=0;
        int start0;
        int start1;
        int start2;
        int start3;
        int start4;
        int start5;
        int start6;
        int start7;
        int start8;
        int start9;
        int start10;
        int start11;
        int start12;
        while((start0=text.indexOf(word0,substringStart0))>=0){
            spannable.setSpan(
                    new ForegroundColorSpan(argb),start0,start0+word0.length(),
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            );
            while((start1=text.indexOf(word1,substringStart1))>=0) {
                spannable.setSpan(
                        new ForegroundColorSpan(argb), start1, start1 + word1.length(),
                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                );
                while((start2=text.indexOf(word2,substringStart2))>=0) {
                    spannable.setSpan(
                            new ForegroundColorSpan(argb), start2, start2 + word2.length(),
                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                    );
                    while((start3=text.indexOf(word3,substringStart3))>=0) {
                        spannable.setSpan(
                                new ForegroundColorSpan(argb), start3, start3 + word3.length(),
                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                        );
                        while((start4=text.indexOf(word4,substringStart4))>=0) {
                            spannable.setSpan(
                                    new ForegroundColorSpan(argb), start4, start4 + word4.length(),
                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                            );
                            while((start5=text.indexOf(word5,substringStart5))>=0) {
                                spannable.setSpan(
                                        new ForegroundColorSpan(argb), start5, start5 + word5.length(),
                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                );
                                while((start6=text.indexOf(word6,substringStart6))>=0) {
                                    spannable.setSpan(
                                            new ForegroundColorSpan(argb), start6, start6 + word6.length(),
                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                    );
                                    while((start7=text.indexOf(word7,substringStart7))>=0) {
                                        spannable.setSpan(
                                                new ForegroundColorSpan(argb), start7, start7 + word7.length(),
                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                        );
                                        while((start8=text.indexOf(word8,substringStart8))>=0) {
                                            spannable.setSpan(
                                                    new ForegroundColorSpan(argb), start8, start8 + word8.length(),
                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                            );
                                            while((start9=text.indexOf(word9,substringStart9))>=0) {
                                                spannable.setSpan(
                                                        new ForegroundColorSpan(argb), start9, start9 + word9.length(),
                                                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                );
                                                while((start10=text.indexOf(word10,substringStart10))>=0) {
                                                    spannable.setSpan(
                                                            new ForegroundColorSpan(argb), start10, start10 + word10.length(),
                                                            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                    );
                                                    while((start11=text.indexOf(word11,substringStart11))>=0) {
                                                        spannable.setSpan(
                                                                new ForegroundColorSpan(argb), start11, start11 + word11.length(),
                                                                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                        );
                                                        while((start12=text.indexOf(word12,substringStart12))>=0) {
                                                            spannable.setSpan(
                                                                    new ForegroundColorSpan(argb), start12, start12 + word12.length(),
                                                                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                                                            );
                                                            substringStart12 = start12 + word12.length();
                                                        }
                                                        substringStart11 = start11 + word11.length();
                                                    }
                                                    substringStart10 = start10 + word10.length();
                                                }
                                                substringStart9 = start9 + word9.length();
                                            }
                                            substringStart8 = start8+word8.length();
                                        }
                                        substringStart7 = start7+word7.length();
                                    }
                                    substringStart6 = start6+word6.length();
                                }
                                substringStart5 = start5+word5.length();
                            }
                            substringStart4 = start4+word4.length();
                        }
                        substringStart3 = start3+word3.length();
                    }
                    substringStart2 = start2+word2.length();
                }
                substringStart1 = start1+word1.length();
            }
            substringStart0 = start0+word0.length();
        }
        return spannable;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContentLabel = (TextView) findViewById(R.id.ContentLabel);
        Content = (EditText) findViewById(R.id.Content);
        CommandLabel = (TextView) findViewById(R.id.CommandLabel);
        Command = (EditText) findViewById(R.id.Command);
        openCommandfile = (Button) findViewById(R.id.openCommandfile);
        openCommandfile.setOnClickListener(openCommandfileClick);
        openIntCommandfile = (Button) findViewById(R.id.openIntCommandfile);
        saveCommandfile = (Button) findViewById(R.id.saveCommandfile);
        saveCommandfile.setOnClickListener(saveCommandfileClick);
        saveExtCommandfile = (Button) findViewById(R.id.saveExtCommandfile);
        saveExtCommandfile.setOnClickListener(saveExtCommandfileClick);
        InputLabel = (TextView) findViewById(R.id.InputLabel);
        InputFile = (EditText) findViewById(R.id.InputFile);
        openInputfile = (Button) findViewById(R.id.openInputfile);
        openInputfile.setOnClickListener(openInputfileClick);
        openIntInputfile = (Button) findViewById(R.id.openIntInputfile);
        saveInputfile = (Button) findViewById(R.id.saveInputfile);
        saveInputfile.setOnClickListener(saveInputfileClick);
        saveExtInputfile = (Button) findViewById(R.id.saveExtInputfile);
        saveExtInputfile.setOnClickListener(saveExtInputfileClick);
        CoordLabel = (TextView) findViewById(R.id.CoordLabel);
        CoordFile = (EditText) findViewById(R.id.CoordFile);
        openCoordfile = (Button) findViewById(R.id.openCoordfile);
        openCoordfile.setOnClickListener(openCoordfileClick);
        openIntCoordfile = (Button) findViewById(R.id.openIntCoordfile);
        saveCoordfile = (Button) findViewById(R.id.saveCoordfile);
        saveCoordfile.setOnClickListener(saveCoordfileClick);
        saveExtCoordfile = (Button) findViewById(R.id.saveExtCoordfile);
        saveExtCoordfile.setOnClickListener(saveExtCoordfileClick);
        generateXYZ = (Button) findViewById(R.id.generateXYZ);
        generateXYZ.setOnClickListener(GenerateXYZClick);
        opsinXYZ = (Button) findViewById(R.id.opsinXYZ);
        opsinXYZ.setOnClickListener(opsinXYZClick);
        RunProgram = (Button) findViewById(R.id.RunProgram);
        RunProgram.setOnClickListener(RunProgramClick);
        saveOutputfile = (Button) findViewById(R.id.saveOutputfile);
        saveOutputfile.setOnClickListener(saveOutputfileClick);
        saveExtOutputfile = (Button) findViewById(R.id.saveExtOutputfile);
        saveExtOutputfile.setOnClickListener(saveExtOutputfileClick);
        Highlight = (Button) findViewById(R.id.Highlight);
        Highlight.setOnClickListener(HighlightClick);
        About = (Button) findViewById(R.id.About);
        About.setOnClickListener(AboutClick);
        textViewX = (TextView) findViewById(R.id.textViewX);
        outputView = (TextView) findViewById(R.id.outputView);
        outputView2 = (EditText) findViewById(R.id.outputView2);
        Graph = (Button) findViewById(R.id.Graph);
        Graph.setOnClickListener(GraphClick);

        License = (Button) findViewById(R.id.License);
        License.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Licenses.class);
                startActivity(intent);
            }
        });

        manual_openbabel = (Button) findViewById(R.id.manual_openbabel);
        manual_openbabel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManualOpenbabel.class);
                startActivity(intent);
            }
        });

        manual_modes = (Button) findViewById(R.id.manual_modes);
        manual_modes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManualModes.class);
                startActivity(intent);
            }
        });

        manual_dftb = (Button) findViewById(R.id.manual_dftb);
        manual_dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManualDftb.class);
                startActivity(intent);
            }
        });

        recipes_dftb = (Button) findViewById(R.id.recipes_dftb);
        recipes_dftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ManualDftbRecipes.class);
                startActivity(intent);
            }
        });

        openIntInputfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DftbWork.class);
                startActivity(intent);
            }
        });

        openIntCoordfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DftbWork1.class);
                startActivity(intent);
            }
        });

        openIntCommandfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DftbCommand.class);
                startActivity(intent);
            }
        });





        // give the app permissions to access the storage
        {
            if (ContextCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);

                } else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST_STORAGE);
                }
                ;
            } else {
                // do nothing
            }
            ;
        }

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        SharedPreferences.Editor editor = wmbPreference.edit();

        if (isFirstRun){

            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setTitle("Please wait...");
            progressDialog.setMessage("Installing DFTB+. It may take a while.");
            progressDialog.show();
            new Thread() {
                public void run() {


                    copyFromAssetsToInternalStorage("assets.zip");
                    copyFromAssetsToInternalStorage("Command.txt");
                    copyFromAssetsToInternalStorage("dftb_in.hsd");
                    copyFromAssetsToInternalStorage("Input.xyz");
                    String zipFilePath = getFilesDir()+"/assets.zip";
                    String destDir = getFilesDir()+"/" ;
//                    unzipfile( zipFilePath, destDir ) ;
                    try {
                        unzip(new File(zipFilePath),destDir);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    exec("rm "+getFilesDir()+"/assets.zip");
//                    unZipFile(getFilesDir()+"/assets.zip");

//                    unzipAssets(MainActivity.this);
//                    copyAsset("assets.zip");
                    exec("mkdir "+Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"/dftb");
//                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//                    imm.hideSoftInputFromWindow(ErgoInput.getWindowToken(), 0);
//                String command = ErgoInput.getText().toString();
//                    String command = "export HOME="+getFilesDir()+"/ ; cd $HOME ; unzip assets.zip ; rm assets.zip ; chmod -R 755 *";
//                    new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);
                    exec("chmod -R 755 "+getFilesDir()+"/");
                    output(exec("ls -la "+getFilesDir()+"/"));
                    output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                    output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                    output5(exec("cat "+getFilesDir()+"/Command.txt"));

                    onFinish();
                }
                public void onFinish(){
                    progressDialog.dismiss();
                }
            }.start();
            editor.putBoolean("FIRSTRUN", false);
            editor.apply();
        }
    }

    private void copyAsset(String filename) {
        File filePath = new File(getFilesDir()+"");
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        AssetManager assetManager = getAssets();
        InputStream in = null;
        OutputStream out = null;
        try {
            in = assetManager.open(filename);
            File outFile = new File(filePath, filename);
            out = new FileOutputStream(outFile);
            copyFile(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    public void onStart()
    {
        super.onStart();

        output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
        output4(exec("cat "+getFilesDir()+"/Input.xyz"));
        output5(exec("cat "+getFilesDir()+"/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/"));
    }

    private View.OnClickListener GenerateXYZClick; {

        GenerateXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertGenerateXYZ();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }


    public void alertGenerateXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("Please write the SMILES string to be converted to XYZ. ")
                .setTitle("OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(SmilesString);
                            outputWriter.close();

//                            String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
//
//                            FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
//                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
//                            outputWriter3.write(ObabelOutput);
//                            outputWriter3.close();

                            // replacement:
                            String command_smiles = "export HOME=/data/data/cz.jh.dftb/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > Input.xyz";
                            new RunConversion().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command_smiles);

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");

//                            FileOutputStream fileout4 = openFileOutput("dftb_in.hsd", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        // do not remove - when using AndroidShell
//                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    private View.OnClickListener opsinXYZClick; {

        opsinXYZClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertOpsinXYZ();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }


    public void alertOpsinXYZ(){
        // creating the EditText widget programatically
        EditText editText100 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("Please write the chemical name according to IUPAC to XYZ conversion. The result will be appended to the actual input file.")
                .setTitle("OPSIN+OpenBABEL conversion")
                .setView(editText100)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String SmilesString = editText100.getText().toString();
//                        String InputFile = MopacInput.getText().toString();
                        try {
                            ////////////////////////////////////
                            NameToStructure nts = NameToStructure.getInstance();
                            NameToStructureConfig ntsconfig = new NameToStructureConfig();
//a new NameToStructureConfig starts as a copy of OPSIN's default configuration
                            ntsconfig.setAllowRadicals(true);
//                OpsinResult result = nts.parseChemicalName("acetamide", ntsconfig);
                            OpsinResult result = nts.parseChemicalName(SmilesString+"", ntsconfig);
                            String smiles = result.getSmiles();
                            /////////////////////////////////////
                            FileOutputStream fileout2 = openFileOutput("temp.smi", MODE_PRIVATE);
                            OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                            outputWriter2.write(smiles);
                            outputWriter2.close();

//                            String ObabelOutput = exec(getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi "+getFilesDir()+"/temp.smi -oxyz --gen3d");
//
//                            FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
//                            OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
//                            outputWriter3.write(ObabelOutput);
//                            outputWriter3.close();

                            // replacement:
                            String command_smiles = "export HOME=/data/data/cz.jh.dftb/files ; cd $HOME ; export BABEL_DATADIR=$HOME/database/openbabel ; "+getApplicationInfo().nativeLibraryDir+"/libobabel.so -ismi temp.smi -oxyz --gen3d > Input.xyz";
                            new RunConversion().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command_smiles);

//                            String SedXyz = exec("sed -e 1,2d "+getFilesDir()+"/temp.xyz");
//
//                            FileOutputStream fileout4 = openFileOutput("dftb_in.hsd", MODE_APPEND);
//                            OutputStreamWriter outputWriter4 = new OutputStreamWriter(fileout4);
////                            outputWriter4.write(InputFile);
//                            outputWriter4.write("\n");
//                            outputWriter4.write(SedXyz);
//                            outputWriter4.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                        exec("rm "+getFilesDir()+"/temp.xyz");
                        // do not remove - when using AndroidShell
//                        exec("rm "+getFilesDir()+"/temp.smi");
                        // here it should be:
                        output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                        output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                        output5(exec("cat "+getFilesDir()+"/Command.txt"));
                        output(exec("ls -la "+getFilesDir()+"/"));
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText100.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }

    // Ignore the bad AsyncTask usage.
    final class RunConversion extends AsyncTask<String, Void, CommandResult> {

        private ProgressDialog dialog;

        @Override protected void onPreExecute() {

            // this is cancellable progress dialog
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Please wait...");
            dialog.setMessage("Conversion is in progress.");
            dialog.setCancelable(false);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog2, int which) {
                    dialog2.dismiss();
                }
            });
            dialog.show();

            // this was the original non-cancellable progress dialog
//            dialog = ProgressDialog.show(MainActivity.this, "Please wait...", "Calculation is in progress.");
//            dialog.setCancelable(false);
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
                dialog.dismiss();
//                outputView2.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                outputView2.setText(colorized(OutputofExecution, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                outputView2.setText(OutputofExecution);
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));}
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Exit Code:</strong> ");
            if (result.isSuccessful()) {
                html.append("<font color='green'>").append(result.exitCode).append("</font>");
            } else {
                html.append("<font color='red'>").append(result.exitCode).append("</font>");
            }
            html.append("</p>");
            // stdout
            if (result.stdout.size() > 0) {
                html.append("<p><strong>STDOUT:</strong></p><p>")
                        .append(result.getStdout().replaceAll("\n", "<br>"))
                        .append("</p>");
            }
            // stderr
            if (result.stderr.size() > 0) {
                html.append("<p><strong>STDERR:</strong></p><p><font color='red'>")
                        .append(result.getStderr().replaceAll("\n", "<br>"))
                        .append("</font></p>");
            }
            return Html.fromHtml(html.toString());
        }

    }

    private View.OnClickListener GraphClick; {

        GraphClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent intent = new Intent(MainActivity.this, Graph.class);
                startActivity(intent);
            }
        };
    }


    private View.OnClickListener openInputfileClick; {

        openInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read6(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener openCoordfileClick; {

        openCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read26(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener openCommandfileClick; {

        openCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                read60(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener saveExtInputfileClick; {

        saveExtInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write1(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener saveExtCoordfileClick; {

        saveExtCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write01(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener saveExtCommandfileClick; {

        saveExtCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write10(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private View.OnClickListener saveExtOutputfileClick; {

        saveExtOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                write2(getApplicationContext());
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }

    private void read6(Context context6) {
        Intent intent6 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent6.addCategory(Intent.CATEGORY_OPENABLE);
        intent6.setType("text/plain");
        startActivityForResult(intent6, READ_FILE6);
    }

    private void read26(Context context26) {
        Intent intent26 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent26.addCategory(Intent.CATEGORY_OPENABLE);
        intent26.setType("text/plain");
        startActivityForResult(intent26, READ_FILE26);
    }

    private void write1(Context context1) {
        Intent intent1 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent1.addCategory(Intent.CATEGORY_OPENABLE);
        intent1.setType("text/plain");
        intent1.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent1, CREATE_FILE20);
    }

    private void write01(Context context01) {
        Intent intent01 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent01.addCategory(Intent.CATEGORY_OPENABLE);
        intent01.setType("text/plain");
        intent01.putExtra(Intent.EXTRA_TITLE,"MyInputFile");
        startActivityForResult(intent01, CREATE_FILE01);
    }

    private void write2(Context context2) {
        Intent intent2 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent2.addCategory(Intent.CATEGORY_OPENABLE);
        intent2.setType("text/plain");
        intent2.putExtra(Intent.EXTRA_TITLE,"MyOutputFile");
        startActivityForResult(intent2, CREATE_FILE21);
    }

    private void read60(Context context60) {
        Intent intent60 = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent60.addCategory(Intent.CATEGORY_OPENABLE);
        intent60.setType("text/plain");
        startActivityForResult(intent60, READ_FILE60);
    }

    private void write10(Context context10) {
        Intent intent10 = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent10.addCategory(Intent.CATEGORY_OPENABLE);
        intent10.setType("text/plain");
        intent10.putExtra(Intent.EXTRA_TITLE,"MyCommand");
        startActivityForResult(intent10, CREATE_FILE200);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == READ_FILE6 && data != null) {
            try {
                documentUri6 = data.getData();
                String myData6 = "";
                ParcelFileDescriptor pfd6 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd6.getFileDescriptor());
                DataInputStream inp6 = new DataInputStream(fileInputStream);
                BufferedReader br6 = new BufferedReader(new InputStreamReader(inp6));
                String strLine6;
                while ((strLine6 = br6.readLine()) != null) {
                    myData6 = myData6 + strLine6 + "\n";
                }
                inp6.close();

                FileOutputStream fileout6 = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                OutputStreamWriter outputWriter6 = new OutputStreamWriter(fileout6);
                outputWriter6.write(myData6);
                outputWriter6.close();
                fileInputStream.close();
                pfd6.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE26 && data != null) {
            try {
                documentUri26 = data.getData();
                String myData26 = "";
                ParcelFileDescriptor pfd26 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream = new FileInputStream(pfd26.getFileDescriptor());
                DataInputStream inp26 = new DataInputStream(fileInputStream);
                BufferedReader br26 = new BufferedReader(new InputStreamReader(inp26));
                String strLine26;
                while ((strLine26 = br26.readLine()) != null) {
                    myData26 = myData26 + strLine26 + "\n";
                }
                inp26.close();

                FileOutputStream fileout26 = openFileOutput("Input.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter26 = new OutputStreamWriter(fileout26);
                outputWriter26.write(myData26);
                outputWriter26.close();
                fileInputStream.close();
                pfd26.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE20 && data != null) {
            // save input file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                String fileContents20X = InputFile.getText().toString();
                FileOutputStream fileout20 = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                OutputStreamWriter outputWriter20 = new OutputStreamWriter(fileout20);
                outputWriter20.write(fileContents20X + "\n");
                outputWriter20.close();

                documentUri20 = data.getData();
                ParcelFileDescriptor pfd20 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream20 = new FileOutputStream(pfd20.getFileDescriptor());
//                String fileContents20 = InputFile.getText().toString();
                String fileContents20 = exec("cat "+getFilesDir()+"/dftb_in.hsd");
                fileOutputStream20.write((fileContents20 + "\n").getBytes());
                fileOutputStream20.close();
                pfd20.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE01 && data != null) {
            // save coordinate file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                String fileContents0X = CoordFile.getText().toString();
                FileOutputStream fileout0 = openFileOutput("Input.xyz", MODE_PRIVATE);
                OutputStreamWriter outputWriter0 = new OutputStreamWriter(fileout0);
                outputWriter0.write(fileContents0X + "\n");
                outputWriter0.close();

                documentUri0 = data.getData();
                ParcelFileDescriptor pfd0 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream0 = new FileOutputStream(pfd0.getFileDescriptor());
//                String fileContents20 = InputFile.getText().toString();
                String fileContents0 = exec("cat "+getFilesDir()+"/Input.xyz");
                fileOutputStream0.write((fileContents0 + "\n").getBytes());
                fileOutputStream0.close();
                pfd0.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE21 && data != null) {
            // save output file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri21 = data.getData();
                ParcelFileDescriptor pfd21 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream21 = new FileOutputStream(pfd21.getFileDescriptor());
                String fileContents21 = outputView2.getText().toString();
                fileOutputStream21.write((fileContents21 + "\n").getBytes());
                fileOutputStream21.close();
                pfd21.close();
                FileOutputStream fileout21 = openFileOutput("Input.out", MODE_PRIVATE);
                OutputStreamWriter outputWriter21 = new OutputStreamWriter(fileout21);
                outputWriter21.write(fileContents21 + "\n");
                outputWriter21.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == READ_FILE60 && data != null) {
            try {
                documentUri60 = data.getData();
                String myData60 = "";
                ParcelFileDescriptor pfd60 = getContentResolver().openFileDescriptor(data.getData(), "r");
                FileInputStream fileInputStream60 = new FileInputStream(pfd60.getFileDescriptor());
                DataInputStream inp60 = new DataInputStream(fileInputStream60);
                BufferedReader br60 = new BufferedReader(new InputStreamReader(inp60));
                String strLine60;
                while ((strLine60 = br60.readLine()) != null) {
                    myData60 = myData60 + strLine60 + "\n";
                }
                inp60.close();

                FileOutputStream fileout60 = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter60 = new OutputStreamWriter(fileout60);
                outputWriter60.write(myData60);
                outputWriter60.close();
                fileInputStream60.close();
                pfd60.close();

            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not read", Toast.LENGTH_SHORT).show();
            }
        }

        if (requestCode == CREATE_FILE200 && data != null) {
            // save command file
            Toast.makeText(getApplicationContext(), "File successfully created", Toast.LENGTH_SHORT).show();
            try {
                documentUri200 = data.getData();
                ParcelFileDescriptor pfd200 = getContentResolver().openFileDescriptor(data.getData(), "w");
                FileOutputStream fileOutputStream200 = new FileOutputStream(pfd200.getFileDescriptor());
                String fileContents200 = Command.getText().toString();
                fileOutputStream200.write((fileContents200 + "\n").getBytes());
                fileOutputStream200.close();
                pfd200.close();
                FileOutputStream fileout200 = openFileOutput("Command.txt", MODE_PRIVATE);
                OutputStreamWriter outputWriter200 = new OutputStreamWriter(fileout200);
                outputWriter200.write(fileContents200);
                outputWriter200.close();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "File not written", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private View.OnClickListener saveInputfileClick; {

        saveInputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveInput();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }


    public void alertSaveInput(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /data/data/cz.jh.dftb/files/work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = InputFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/work");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener saveCoordfileClick; {

        saveCoordfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveCoord();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }


    public void alertSaveCoord(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /data/data/cz.jh.dftb/files/work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = CoordFile.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile+"\n");
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/work");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener saveCommandfileClick; {

        saveCommandfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                alertSaveCommand();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }


    public void alertSaveCommand(){
        // creating the EditText widget programatically
        EditText editText10 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /data/data/cz.jh.dftb/files/commands")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText10)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String Inputfile = Command.getText().toString();
                        String SaveInputName = editText10.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveInputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(Inputfile);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveInputName+" "+getFilesDir()+"/commands");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText10.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }


    private View.OnClickListener RunProgramClick; {

        RunProgramClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                String Inputfile = InputFile.getText().toString();
                String Arguments = Command.getText().toString();
                String Coord = CoordFile.getText().toString();
                try {
                    FileOutputStream fileout = openFileOutput("dftb_in.hsd", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(Inputfile);
                    outputWriter.close();
                    FileOutputStream fileout2 = openFileOutput("Command.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter2 = new OutputStreamWriter(fileout2);
                    outputWriter2.write(Arguments);
                    outputWriter2.close();
                    FileOutputStream fileout3 = openFileOutput("Input.xyz", MODE_PRIVATE);
                    OutputStreamWriter outputWriter3 = new OutputStreamWriter(fileout3);
                    outputWriter3.write(Coord);
                    outputWriter3.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Arguments = Arguments.replace(" obabel ", " "+getApplicationInfo().nativeLibraryDir+"/libobabel.so ");
                Arguments = Arguments.replace(" dftb ", " "+getApplicationInfo().nativeLibraryDir+"/libdftb.so ");
                Arguments = Arguments.replace(" integvalue ", " "+getApplicationInfo().nativeLibraryDir+"/libintegvalue.so ");
                Arguments = Arguments.replace(" modes ", " "+getApplicationInfo().nativeLibraryDir+"/libmodes.so ");
                Arguments = Arguments.replace(" xbbc ", " "+getApplicationInfo().nativeLibraryDir+"/libxbbc.so ");
                Arguments = Arguments.replace(" xbvm ", " "+getApplicationInfo().nativeLibraryDir+"/libxbvm.so ");
                Arguments = Arguments.replace(" polyvalue ", " "+getApplicationInfo().nativeLibraryDir+"/libpolyvalue.so ");
                Arguments = Arguments.replace(" printunits ", " "+getApplicationInfo().nativeLibraryDir+"/libprintunits.so ");
                Arguments = Arguments.replace(" skderivs ", " "+getApplicationInfo().nativeLibraryDir+"/libskderivs.so ");
                Arguments = Arguments.replace(" splvalue ", " "+getApplicationInfo().nativeLibraryDir+"/libsplvalue.so ");
                Arguments = Arguments.replace(" waveplot ", " "+getApplicationInfo().nativeLibraryDir+"/libwaveplot.so ");
                Arguments = Arguments.replace(" buildwire ", " "+getApplicationInfo().nativeLibraryDir+"/libbuildwire.so ");
                Arguments = Arguments.replace(" dftd4 ", " "+getApplicationInfo().nativeLibraryDir+"/libdftd4.so ");
                Arguments = Arguments.replace(" flux ", " "+getApplicationInfo().nativeLibraryDir+"/libflux.so ");
                Arguments = Arguments.replace(" makecube ", " "+getApplicationInfo().nativeLibraryDir+"/libmakecube.so ");
                Arguments = Arguments.replace(" mctc-convert ", " "+getApplicationInfo().nativeLibraryDir+"/libmctc-convert.so ");
                Arguments = Arguments.replace(" mstore-fortranize ", " "+getApplicationInfo().nativeLibraryDir+"/libmstore-fortranize.so ");
                Arguments = Arguments.replace(" mstore-info ", " "+getApplicationInfo().nativeLibraryDir+"/libmstore-info.so ");
                Arguments = Arguments.replace(" multicharge ", " "+getApplicationInfo().nativeLibraryDir+"/libmulticharge.so ");
                Arguments = Arguments.replace(" phonons ", " "+getApplicationInfo().nativeLibraryDir+"/libphonons.so ");
                Arguments = Arguments.replace(" s-dftd3 ", " "+getApplicationInfo().nativeLibraryDir+"/libs-dftd3.so ");
                Arguments = Arguments.replace(" setupgeom ", " "+getApplicationInfo().nativeLibraryDir+"/libsetupgeom.so ");
                Arguments = Arguments.replace(" tblite ", " "+getApplicationInfo().nativeLibraryDir+"/libtblite.so ");

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(InputFile.getWindowToken(), 0);
//                String command = ErgoInput.getText().toString();
                String command = Arguments;
//                String command = " export HOME="+getFilesDir()+"/ ; cd $HOME ; "+getApplicationInfo().nativeLibraryDir+"/"+NameOfProgram+" "+Arguments;

                new RunCommandTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, command);

                // TODO Auto-generated method stub //
//                openprogressdialog();
            }
        };
    }

    // Ignore the bad AsyncTask usage.
    final class RunCommandTask extends AsyncTask<String, Void, CommandResult> {

        private ProgressDialog dialog;

        @Override protected void onPreExecute() {

            // this is cancellable progress dialog
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Please wait...");
            dialog.setMessage("Calculation is in progress.");
            dialog.setCancelable(false);
            dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog2, int which) {
                    dialog2.dismiss();
                }
            });
            dialog.show();

            // this was the original non-cancellable progress dialog
//            dialog = ProgressDialog.show(MainActivity.this, "Please wait...", "Calculation is in progress.");
//            dialog.setCancelable(false);
        }

        @Override protected CommandResult doInBackground(String... commands) {
            return com.jrummyapps.android.shell.Shell.SH.run(commands);
        }

        @Override protected void onPostExecute(CommandResult result) {
            if (!isFinishing()) {
                dialog.dismiss();
//                outputView2.setText(resultToHtml(result));
                String OutputofExecution = resultToHtml(result).toString();
                try {
                    FileOutputStream fileout = openFileOutput("LastExecutionOutput.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                    outputWriter.write(OutputofExecution);
                    outputWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                outputView2.setText(colorized(OutputofExecution, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                outputView2.setText(OutputofExecution);
                output(exec("ls -la "+getFilesDir()+"/"));
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));}
        }

        private Spanned resultToHtml(CommandResult result) {
            StringBuilder html = new StringBuilder();
            // exit status
            html.append("<p><strong>Exit Code:</strong> ");
            if (result.isSuccessful()) {
                html.append("<font color='green'>").append(result.exitCode).append("</font>");
            } else {
                html.append("<font color='red'>").append(result.exitCode).append("</font>");
            }
            html.append("</p>");
            // stdout
            if (result.stdout.size() > 0) {
                html.append("<p><strong>STDOUT:</strong></p><p>")
                        .append(result.getStdout().replaceAll("\n", "<br>"))
                        .append("</p>");
            }
            // stderr
            if (result.stderr.size() > 0) {
                html.append("<p><strong>STDERR:</strong></p><p><font color='red'>")
                        .append(result.getStderr().replaceAll("\n", "<br>"))
                        .append("</font></p>");
            }
            return Html.fromHtml(html.toString());
        }

    }


    public void output2(final String str2) {
        Runnable proc2 = new Runnable() {
            public void run() {
                outputView2.setText(str2);
            }
        };
        handler.post(proc2);
    }















    private View.OnClickListener saveOutputfileClick; {

        saveOutputfileClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertSaveOutput();
                output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                output5(exec("cat "+getFilesDir()+"/Command.txt"));
                output(exec("ls -la "+getFilesDir()+"/"));
            }
        };
    }





    public void alertSaveOutput(){
        // creating the EditText widget programatically
        EditText editText15 = new EditText(MainActivity.this);
        // create the AlertDialog as final
        final AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
                .setMessage("The file will be saved in the folder /data/data/cz.jh.dftb/files/work")
                .setTitle("Please write the desired filename (if already present, it will be overwritten)")
                .setView(editText15)

                // Set the action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String OutputProtocol = outputView2.getText().toString();
                        String SaveOutputName = editText15.getText().toString();
                        try {
                            FileOutputStream fileout = openFileOutput(SaveOutputName, MODE_PRIVATE);
                            OutputStreamWriter outputWriter = new OutputStreamWriter(fileout);
                            outputWriter.write(OutputProtocol);
                            outputWriter.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        exec("mv "+getFilesDir()+"/"+SaveOutputName+" "+getFilesDir()+"/work");
                    }
                })

                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // removes the AlertDialog in the screen
                    }
                })
                .create();

        // set the focus change listener of the EditText10
        // this part will make the soft keyboard automatically visible
        editText15.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        });

        dialog.show();

    }















    private View.OnClickListener HighlightClick; {

        HighlightClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                openhighlightdialog();
            }
        };
    }


    private void openhighlightdialog() {
        // TODO Auto-generated method stub //
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Please wait...");
        progressDialog.setMessage("Highlighting numbers is in progress...");
        progressDialog.setCancelable(false);
        progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        progressDialog.show();

        new Thread() {
            public void run() {
                try {
                    outputX(exec("cat "+getFilesDir()+"/LastExecutionOutput.txt"));
                    output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
                    output4(exec("cat "+getFilesDir()+"/Input.xyz"));
                    output5(exec("cat "+getFilesDir()+"/Command.txt"));
                    output(exec("ls -la "+getFilesDir()+"/"));
                    Toast.makeText(getApplicationContext(), "Numbers highlighted.", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }

                onFinish();
            }

            // for displaying the output in the second TextView there must be different output2 than output, including the str2/proc2 variables
            public void outputX(final String strX) {
                Runnable procX = new Runnable() {
                    public void run() {
                        outputView2.setText(colorized(strX, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
                    }
                };
                handler.post(procX);
            }

            public void onFinish() {
                progressDialog.dismiss();
            }
        }.start();
    }


    private View.OnClickListener AboutClick; {

        AboutClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertAbout();
            }
        };
    }

    public void alertAbout() {

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("About the DFTB+ app")
                .setMessage(exec("cat "+getFilesDir()+"/About.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
        output3(exec("cat "+getFilesDir()+"/dftb_in.hsd"));
        output4(exec("cat "+getFilesDir()+"/Input.xyz"));
        output5(exec("cat "+getFilesDir()+"/Command.txt"));
        output(exec("ls -la "+getFilesDir()+"/"));
    }

    // for displaying the output in the second TextView there must be different output3 than output, including the str3/proc3 variables
    public void output3(final String str3) {
        Runnable proc3 = new Runnable() {
            public void run() {
                InputFile.setText(str3);
            }
        };
        handler.post(proc3);
    }
    public void output4(final String str4) {
        Runnable proc4 = new Runnable() {
            public void run() {
                CoordFile.setText(str4);
            }
        };
        handler.post(proc4);
    }
    public void output5(final String str5) {
        Runnable proc5 = new Runnable() {
            public void run() {
                Command.setText(str5);
            }
        };
        handler.post(proc5);
    }
    public void output(final String str) {
        Runnable proc = new Runnable() {
            public void run() {
                Content.setText(colorized(str, "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ".", "+", "-", Color.RED));
            }
        };
        handler.post(proc);
    }

    // Executes UNIX command.
    private String exec(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
            int read;
            char[] buffer = new char[4096];
            StringBuffer output = new StringBuffer();
            while ((read = reader.read(buffer)) > 0) {
                output.append(buffer, 0, read);
            }
            reader.close();
            process.waitFor();
            return output.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    protected void copyFromAssetsToInternalStorage(String filename){
        AssetManager assetManager = getAssets();

        try {
            InputStream input = assetManager.open(filename);
            OutputStream output = openFileOutput(filename, Context.MODE_PRIVATE);

            copyFile2(input, output);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void unZipFile(String filename){
        try {
            ZipInputStream zipInputStream = new ZipInputStream(openFileInput(filename));
            ZipEntry zipEntry;

            while((zipEntry = zipInputStream.getNextEntry()) != null){
                FileOutputStream zipOutputStream = openFileOutput(zipEntry.getName(), MODE_PRIVATE);

                int length;
                byte[] buffer = new byte[1024];

                while((length = zipInputStream.read(buffer)) > 0){
                    zipOutputStream.write(buffer, 0, length);
                }

                zipOutputStream.close();
                zipInputStream.closeEntry();
            }
            zipInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void copyFile2(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private static void unzipfile( String zipFilePath, String destDir ) {
        File dir = new File( destDir ) ;
        // creating an output directory if it doesn't exist already
        if( !dir.exists( ) ) dir.mkdirs( ) ;
        FileInputStream FiS ;
        // buffer to read and write data in the file
        byte[ ] buffer = new byte[ 1024 ] ;
        try {
            FiS = new FileInputStream( zipFilePath ) ;
            ZipInputStream ZiS = new ZipInputStream( FiS ) ;
            ZipEntry ZE = ZiS.getNextEntry( ) ;
            while( ZE != null ) {
                String fileName = ZE.getName( ) ;
                File newFile = new File( destDir + File.separator + fileName ) ;
                System.out.println( " Unzipping to " + newFile.getAbsolutePath( ) ) ;
                // create directories for sub directories in zip
                new File( newFile.getParent( ) ).mkdirs( ) ;
                FileOutputStream FoS = new FileOutputStream( newFile ) ;
                int len ;
                while ( ( len = ZiS.read( buffer ) )  > 0 ) {
                    FoS.write( buffer, 0, len ) ;
                }
                FoS.close( ) ;
                // close this ZipEntry
                ZiS.closeEntry( ) ;
                ZE = ZiS.getNextEntry( ) ;
            }
            // close last ZipEntry
            ZiS.closeEntry( ) ;
            ZiS.close( ) ;
            FiS.close( ) ;
        } catch ( IOException e ) {
            e.printStackTrace( ) ;
        }
    }

    public static void unzip(File source, String out) throws IOException {
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(source))) {

            ZipEntry entry = zis.getNextEntry();

            while (entry != null) {

                File file = new File(out, entry.getName());

                if (entry.isDirectory()) {
                    file.mkdirs();
                } else {
                    File parent = file.getParentFile();

                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {

                        int bufferSize = Math.toIntExact(entry.getSize());
                        byte[] buffer = new byte[bufferSize > 0 ? bufferSize : 1];
                        int location;

                        while ((location = zis.read(buffer)) != -1) {
                            bos.write(buffer, 0, location);
                        }
                    }
                }
                entry = zis.getNextEntry();
            }
        }
    }

}