package cz.jh.dftb;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Licenses extends MainActivity {
    TextView license_label;
    Button license0;
    Button license5;
    Button license7;
    Button license10;
    Button license11;
    Button licenseGV;
    Button license_arpack;
    Button license_dftb;
    Button license_sk;
    Button lt_dftb;
    Button lt_sk;
    Button opsin;
    Button python;
    Button android_shell;
    Button license1_dftd4;
    Button license2_dftd4;
    Button license_mctc;
    Button license_mstore;
    Button license_multicharge;
    Button license1_sdftd3;
    Button license2_sdftd3;
    Button license1_tblite;
    Button license2_tblite;
    Button license1_tomlf;
    Button license2_tomlf;
    Button license_openblas;
    Button licenseGBSA;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.licenses);

        license_label = (TextView) findViewById(R.id.license_label);

        license0 = (Button) findViewById(R.id.license0);
        license0.setOnClickListener(license0Click);
        license5 = (Button) findViewById(R.id.license5);
        license5.setOnClickListener(license5Click);
        license7 = (Button) findViewById(R.id.license7);
        license7.setOnClickListener(license7Click);
        license10 = (Button) findViewById(R.id.license10);
        license10.setOnClickListener(license10Click);
        license11 = (Button) findViewById(R.id.license11);
        license11.setOnClickListener(license11Click);
        licenseGV = (Button) findViewById(R.id.licenseGV);
        licenseGV.setOnClickListener(licenseGVClick);
        license_dftb = (Button) findViewById(R.id.license_dftb);
        license_dftb.setOnClickListener(license_dftbClick);
        license_sk = (Button) findViewById(R.id.license_sk);
        license_sk.setOnClickListener(license_skClick);
        license_arpack = (Button) findViewById(R.id.license_arpack);
        license_arpack.setOnClickListener(license_arpackClick);
        lt_dftb = (Button) findViewById(R.id.lt_dftb);
        lt_dftb.setOnClickListener(lt_dftbClick);
        lt_sk = (Button) findViewById(R.id.lt_sk);
        lt_sk.setOnClickListener(lt_skClick);
        opsin = (Button) findViewById(R.id.opsin);
        opsin.setOnClickListener(opsinClick);
        python = (Button) findViewById(R.id.python);
        python.setOnClickListener(pythonClick);
        android_shell = (Button) findViewById(R.id.android_shell);
        android_shell.setOnClickListener(android_shellClick);
        license1_dftd4 = (Button) findViewById(R.id.license1_dftd4);
        license1_dftd4.setOnClickListener(license1_dftd4Click);
        license2_dftd4 = (Button) findViewById(R.id.license2_dftd4);
        license2_dftd4.setOnClickListener(license2_dftd4Click);
        license_mctc = (Button) findViewById(R.id.license_mctc);
        license_mctc.setOnClickListener(license_mctcClick);
        license_mstore = (Button) findViewById(R.id.license_mstore);
        license_mstore.setOnClickListener(license_mstoreClick);
        license_multicharge = (Button) findViewById(R.id.license_multicharge);
        license_multicharge.setOnClickListener(license_multichargeClick);
        license1_sdftd3 = (Button) findViewById(R.id.license1_sdftd3);
        license1_sdftd3.setOnClickListener(license1_sdftd3Click);
        license2_sdftd3 = (Button) findViewById(R.id.license2_sdftd3);
        license2_sdftd3.setOnClickListener(license2_sdftd3Click);
        license1_tblite = (Button) findViewById(R.id.license1_tblite);
        license1_tblite.setOnClickListener(license1_tbliteClick);
        license2_tblite = (Button) findViewById(R.id.license2_tblite);
        license2_tblite.setOnClickListener(license2_tbliteClick);
        license1_tomlf = (Button) findViewById(R.id.license1_tomlf);
        license1_tomlf.setOnClickListener(license1_tomlfClick);
        license2_tomlf = (Button) findViewById(R.id.license2_tomlf);
        license2_tomlf.setOnClickListener(license2_tomlfClick);
        license_openblas = (Button) findViewById(R.id.license_openblas);
        license_openblas.setOnClickListener(license_openblasClick);
        licenseGBSA = (Button) findViewById(R.id.licenseGBSA);
        licenseGBSA.setOnClickListener(licenseGBSAClick);

        quit = (Button) findViewById(R.id.quit);
        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Licenses.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private View.OnClickListener licenseGBSAClick; {
        licenseGBSAClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1gbsa();
            }
        };
    }

    public void alert1gbsa() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-GBSA-PARAMETERS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-GBSA-PARAMETERS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_openblasClick; {
        license_openblasClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1openblas();
            }
        };
    }

    public void alert1openblas() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPENBLAS")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPENBLAS.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener pythonClick; {
        pythonClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1python();
            }
        };
    }

    public void alert1python() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-PYTHON")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-PYTHON.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_dftd4Click; {
        license1_dftd4Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1dftd4();
            }
        };
    }

    public void alert1dftd4() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-DFTD4")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-DFTD4.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_dftd4Click; {
        license2_dftd4Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2dftd4();
            }
        };
    }

    public void alert2dftd4() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-DFTD4")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-DFTD4.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_mctcClick; {
        license_mctcClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmctc();
            }
        };
    }

    public void alertmctc() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MCTC-LIB")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MCTC-LIB.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_mstoreClick; {
        license_mstoreClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmstore();
            }
        };
    }

    public void alertmstore() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MSTORE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MSTORE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_multichargeClick; {
        license_multichargeClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertmc();
            }
        };
    }

    public void alertmc() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-MULTICHARGE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-MULTICHARGE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_sdftd3Click; {
        license1_sdftd3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1sdftd3();
            }
        };
    }

    public void alert1sdftd3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-s-DFTD3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-S-DFTD3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_sdftd3Click; {
        license2_sdftd3Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2sdftd3();
            }
        };
    }

    public void alert2sdftd3() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-s-DFTD3")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-S-DFTD3.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_tbliteClick; {
        license1_tbliteClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1tblite();
            }
        };
    }

    public void alert1tblite() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-TBLITE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-TBLITE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_tbliteClick; {
        license2_tbliteClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2tblite();
            }
        };
    }

    public void alert2tblite() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-TBLITE")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-TBLITE.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license1_tomlfClick; {
        license1_tomlfClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert1tomlf();
            }
        };
    }

    public void alert1tomlf() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE1-TOML-F")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE1-TOML-F.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license2_tomlfClick; {
        license2_tomlfClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert2tomlf();
            }
        };
    }

    public void alert2tomlf() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE2-TOML-F")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE2-TOML-F.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener android_shellClick; {
        android_shellClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertAS();
            }
        };
    }

    public void alertAS() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ANDROID-SHELL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ANDROID_SHELL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener opsinClick; {
        opsinClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertOpsin();
            }
        };
    }

    public void alertOpsin() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPSIN")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPSIN.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener licenseGVClick; {
        licenseGVClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alertGV();
            }
        };
    }

    public void alertGV() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-GRAPHVIEW")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-GRAPHVIEW.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license0Click; {
        license0Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert0();
            }
        };
    }

    public void alert0() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ACPDFVIEW")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ACPDFVIEW.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license5Click; {
        license5Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert5();
            }
        };
    }

    public void alert5() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-LAPACK")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-LAPACK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license7Click; {
        license7Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert7();
            }
        };
    }

    public void alert7() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-OPENBABEL")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-OPENBABEL.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license10Click; {
        license10Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert10();
            }
        };
    }

    public void alert10() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-X11-BASIC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-X11-BASIC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license11Click; {
        license11Click = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert11();
            }
        };
    }

    public void alert11() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING_TERMS_X11-BASIC")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-X11-BASIC.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }


    private View.OnClickListener license_dftbClick; {
        license_dftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert17();
            }
        };
    }

    public void alert17() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-DFTB+")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-DFTB+.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_arpackClick; {
        license_arpackClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert18();
            }
        };
    }

    public void alert18() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-ARPACK")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-ARPACK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener license_skClick; {
        license_skClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert19();
            }
        };
    }

    public void alert19() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSE-SLATER_KOSTER_FILES")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSE-SK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener lt_skClick; {
        lt_skClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert20();
            }
        };
    }

    public void alert20() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING TERMS-SLATER_KOSTER_FILES")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-SK.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }

    private View.OnClickListener lt_dftbClick; {
        lt_dftbClick = new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub //
                alert21();
            }
        };
    }

    public void alert21() {
        new AlertDialog.Builder(Licenses.this)
                .setTitle("LICENSING TERMS-DFTB+")
                .setMessage(exec("cat "+getFilesDir()+"/licenses/LICENSING_TERMS-DFTB+.txt"))
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
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

}
