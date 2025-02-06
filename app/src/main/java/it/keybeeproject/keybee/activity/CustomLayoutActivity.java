package it.keybeeproject.keybee.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import it.keybeeproject.keybee.R;
import it.keybeeproject.keybee.adapter.PopUpAdapter;
import it.keybeeproject.keybee.utility.PrefData;
import it.keybeeproject.keybee.utility.TypefaceSpan;

public class CustomLayoutActivity extends AppCompatActivity {//implements IabBroadcastReceiver.IabBroadcastListener {

    String[] array,array1,a,c,d,e,g,h,i,j,k,l,o,n,r,s,t,u,w,y,z;
    int currentKeyboardLayout;
    Spinner Spin_A0, Spin_A1, Spin_A2, Spin_A3, Spin_B0, Spin_B1, Spin_B2, Spin_B3, Spin_C0, Spin_C1, Spin_C2, Spin_C3, Spin_D0,
            Spin_D1, Spin_D3, Spin_E0, Spin_E1, Spin_E2, Spin_E3, Spin_F0, Spin_F1, Spin_F2, Spin_F3, Spin_G0, Spin_G1, Spin_G2;
    TextView Text_A0, Text_A1, Text_A2, Text_A3, Text_B0, Text_B1, Text_B2, Text_B3, Text_C0, Text_C1, Text_C2, Text_C3, Text_D0, Text_D1, Text_D3,
            Text_E0, Text_E1, Text_E2, Text_E3, Text_F0, Text_F1, Text_F2, Text_F3, Text_G0, Text_G1, Text_G2, reset, subscribe, main_txt;
    //private IabHelper iabHelper;
    ArrayList<String> list;



    ArrayAdapter A0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        setContentView(R.layout.activity_custom_layout);
        initGloble();
        Onclick();
        setData();

        subscribe.setText(R.string.use);

    }


    private void setData() {
        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_A0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.AO_EN, array[0]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_A0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.AO_IT, array[0]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_A0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.AO_SP, array[0]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_A0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.AO_DE, array[0]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_A1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A1_EN, array[1]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_A1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A1_IT, array[1]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_A1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A1_SP, array[1]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_A1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A1_DE, array[1]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_A2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A2_EN, array[2]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_A2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A2_IT, array[2]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_A2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A2_SP, array[2]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_A2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A2_DE, array[2]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_A3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A3_EN, array[3]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_A3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A3_IT, array[3]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_A3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A3_SP, array[3]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_A3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.A3_DE, array[3]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_B0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B0_EN, array[4]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_B0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B0_IT, array[4]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_B0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B0_SP, array[4]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_B0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B0_DE, array[4]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_B1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B1_EN, array[5]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_B1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B1_IT, array[5]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_B1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B1_SP, array[5]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_B1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B1_DE, array[5]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_B2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B2_EN, array[6]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_B2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B2_IT, array[6]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_B2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B2_SP, array[6]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_B2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B2_DE, array[6]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_B3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B3_EN, array[7]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_B3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B3_IT, array[7]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_B3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B3_SP, array[7]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_B3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.B3_DE, array[7]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_C0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C0_EN, array[8]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_C0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C0_IT, array[8]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_C0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C0_SP, array[8]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_C0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C0_DE, array[8]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_C1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C1_EN, array[9]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_C1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C1_IT, array[9]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_C1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C1_SP, array[9]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_C1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C1_DE, array[9]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_C2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C2_EN, array[10]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_C2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C2_IT, array[10]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_C2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C2_SP, array[10]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_C2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C2_DE, array[10]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_C3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C3_EN, array[11]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_C3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C3_IT, array[11]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_C3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C3_SP, array[11]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_C3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.C3_DE, array[11]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_D0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D0_EN, array[12]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_D0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D0_IT, array[12]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_D0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D0_SP, array[12]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_D0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D0_DE, array[12]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_D1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D1_EN, array[13]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_D1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D1_IT, array[13]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_D1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D1_SP, array[13]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_D1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D1_DE, array[13]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_D3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D3_EN, array[14]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_D3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D3_IT, array[14]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_D3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D3_SP, array[14]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_D3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.D3_DE, array[14]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_E0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E0_EN, array[15]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_E0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E0_IT, array[15]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_E0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E0_SP, array[15]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_E0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E0_DE, array[15]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_E1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_EN, array[16]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_E1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_IT, array[16]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_E1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_SP, array[16]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_E1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_DE, array[16]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_E2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E2_EN, array[17]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_E2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E2_IT, array[17]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_E2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E2_SP, array[17]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_E2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_DE, array[17]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_E3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E3_EN, array[18]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_E3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E3_IT, array[18]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_E3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E3_SP, array[18]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_E3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.E1_DE, array[18]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_F0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F0_EN, array[19]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_F0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F0_IT, array[19]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_F0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F0_SP, array[19]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_F0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F0_DE, array[19]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_F1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F1_EN, array[20]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_F1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F1_IT, array[20]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_F1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F1_SP, array[20]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_F1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F1_DE, array[20]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_F2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F2_EN, array[21]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_F2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F2_IT, array[21]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_F2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F2_SP, array[21]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_F2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F2_DE, array[21]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_F3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F3_EN, array[22]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_F3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F3_IT, array[22]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_F3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F3_SP, array[22]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_F3.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.F3_DE, array[22]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_G0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G0_EN, array[23]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_G0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G0_IT, array[23]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_G0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G0_SP, array[23]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_G0.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G0_DE, array[23]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_G1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G1_EN, array[24]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_G1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G1_IT, array[24]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_G1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G1_SP, array[24]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_G1.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G1_DE, array[24]).toUpperCase()));
        }

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
            Spin_G2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G2_EN, array[25]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            Spin_G2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G2_IT, array[25]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            Spin_G2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G2_SP, array[25]).toUpperCase()));
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            Spin_G2.setSelection(A0.getPosition(PrefData.getStringPrefs(CustomLayoutActivity.this, PrefData.G2_DE, array[25]).toUpperCase()));
        }

    }

    private void Onclick() {

           Text_A0.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){
                       if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k).size()!=0){
                           list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k);
                       }else{
                           list= new ArrayList<String>(Arrays.asList(k));
                       }
                       openPopupDialog(list,PrefData.k);
                   }
                   if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){
                       if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g).size()!=0){
                           list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g);
                       }else{
                           list= new ArrayList<String>(Arrays.asList(g));
                       }
                       openPopupDialog(list,PrefData.g);
                   }

               }
           });

            Text_A1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(y));
                        }
                        openPopupDialog(list,PrefData.y);
                    }

                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(z));
                        }
                        openPopupDialog(list,PrefData.z);
                    }

                }
            });

            Text_B0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(z));
                        }
                        openPopupDialog(list,PrefData.z);
                    }
                }
            });

            Text_B1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(d));
                        }
                        openPopupDialog(list,PrefData.d);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(r));
                        }
                        openPopupDialog(list,PrefData.r);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(g));
                        }
                        openPopupDialog(list,PrefData.g);
                    }
                }
            });

            Text_B2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(r));
                        }
                        openPopupDialog(list,PrefData.r);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(l));
                        }
                        openPopupDialog(list,PrefData.r);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(r));
                        }
                        openPopupDialog(list,PrefData.r);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.r);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(r));
                        }
                        openPopupDialog(list,PrefData.r);
                    }
                }
            });

            Text_C0.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(u));
                        }
                        openPopupDialog(list,PrefData.u);
                    }

                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(u));
                        }
                        openPopupDialog(list,PrefData.u);
                    }
                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(u));
                        }
                        openPopupDialog(list,PrefData.u);
                    }


                    if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){
                        if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u).size()!=0){
                            list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.u);
                        }else{
                            list= new ArrayList<String>(Arrays.asList(u));
                        }
                        openPopupDialog(list,PrefData.u);
                    }


                }
            });

        Text_C1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(e));
                    }
                    openPopupDialog(list,PrefData.e);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(o));
                    }
                    openPopupDialog(list,PrefData.o);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(n));
                    }
                    openPopupDialog(list,PrefData.n);
                }


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(o));
                    }
                    openPopupDialog(list,PrefData.o);
                }


            }
        });

        Text_C2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(a));
                    }
                    openPopupDialog(list,PrefData.a);


                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(a));
                    }
                    openPopupDialog(list,PrefData.a);


                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(e));
                    }
                    openPopupDialog(list,PrefData.e);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){
                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(e));
                    }
                    openPopupDialog(list,PrefData.e);
                }


            }
        });



        Text_C3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(s));
                    }
                    openPopupDialog(list,PrefData.s);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(l));
                    }
                    openPopupDialog(list,PrefData.l);
                }

            }
        });

        Text_D0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(h));
                    }
                    openPopupDialog(list,PrefData.h);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(h));
                    }
                    openPopupDialog(list,PrefData.h);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(h));
                    }
                    openPopupDialog(list,PrefData.h);
                }

            }
        });

        Text_D1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(i));
                    }
                    openPopupDialog(list,PrefData.i);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(i));
                    }
                    openPopupDialog(list,PrefData.i);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(i));
                    }
                    openPopupDialog(list,PrefData.i);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.h);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(h));
                    }
                    openPopupDialog(list,PrefData.h);
                }


            }
        });

        Text_D3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(t));
                    }
                    openPopupDialog(list,PrefData.t);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(s));
                    }
                    openPopupDialog(list,PrefData.s);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(d));
                    }
                    openPopupDialog(list,PrefData.d);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(a));
                    }
                    openPopupDialog(list,PrefData.a);
                }



            }
        });

        Text_E0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(c));
                    }
                    openPopupDialog(list,PrefData.c);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(c));
                    }
                    openPopupDialog(list,PrefData.c);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(c));
                    }
                    openPopupDialog(list,PrefData.c);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.i);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(i));
                    }
                    openPopupDialog(list,PrefData.i);
                }


            }
        });

        Text_E1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(l));
                    }
                    openPopupDialog(list,PrefData.l);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(y));
                    }
                    openPopupDialog(list,PrefData.y);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(s));
                    }
                    openPopupDialog(list,PrefData.s);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(t));
                    }
                    openPopupDialog(list,PrefData.t);
                }


            }
        });

        Text_E2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(o));
                    }
                    openPopupDialog(list,PrefData.o);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.e);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(e));
                    }
                    openPopupDialog(list,PrefData.e);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.a);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(a));
                    }
                    openPopupDialog(list,PrefData.a);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.s);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(s));
                    }
                    openPopupDialog(list,PrefData.s);
                }


            }
        });

        Text_E3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(n));
                    }
                    openPopupDialog(list,PrefData.n);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(t));
                    }
                    openPopupDialog(list,PrefData.t);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(d));
                    }
                    openPopupDialog(list,PrefData.d);
                }


            }
        });

        Text_F0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(k));
                    }
                    openPopupDialog(list,PrefData.k);
                }


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.c);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(c));
                    }
                    openPopupDialog(list,PrefData.c);
                }



            }
        });

        Text_F1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.l);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(l));
                    }
                    openPopupDialog(list,PrefData.l);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(n));
                    }
                    openPopupDialog(list,PrefData.n);
                }
            }
        });

        Text_F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(g));
                    }
                    openPopupDialog(list,PrefData.g);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.d);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(d));
                    }
                    openPopupDialog(list,PrefData.d);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.t);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(t));
                    }
                    openPopupDialog(list,PrefData.t);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(y));
                    }
                    openPopupDialog(list,PrefData.y);
                }



            }
        });

        Text_F3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.n);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(n));
                    }
                    openPopupDialog(list,PrefData.n);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.o);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(o));
                    }
                    openPopupDialog(list,PrefData.o);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(k));
                    }
                    openPopupDialog(list,PrefData.k);
                }
            }
        });

        Text_G0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(k));
                    }
                    openPopupDialog(list,PrefData.k);
                }



                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.k);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(k));
                    }
                    openPopupDialog(list,PrefData.k);
                }
            }
        });

        Text_G1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.y);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(y));
                    }
                    openPopupDialog(list,PrefData.y);
                }


                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.g);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(g));
                    }
                    openPopupDialog(list,PrefData.g);
                }
            }
        });

        Text_G2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(z));
                    }
                    openPopupDialog(list,PrefData.z);
                }

                if(currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH){

                    if( PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z)!=null && PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z).size()!=0){
                        list = PrefData.getArrayListPref(CustomLayoutActivity.this,PrefData.z);
                    }else{
                        list= new ArrayList<String>(Arrays.asList(z));
                    }
                    openPopupDialog(list,PrefData.z);
                }


            }
        });


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                    PrefData.remove(CustomLayoutActivity.this, PrefData.AO_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A2_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B2_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C2_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E2_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F2_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F3_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G0_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G1_EN);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G2_EN);
                } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                    PrefData.remove(CustomLayoutActivity.this, PrefData.AO_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A2_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B2_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C2_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E2_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F2_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F3_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G0_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G1_IT);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G2_IT);
                } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                    PrefData.remove(CustomLayoutActivity.this, PrefData.AO_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A2_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B2_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C2_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E2_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F2_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F3_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G0_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G1_SP);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G2_SP);
                } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                    PrefData.remove(CustomLayoutActivity.this, PrefData.AO_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A2_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.A3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B2_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.B3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C2_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.C3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.D3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E2_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.E3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F2_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.F3_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G0_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G1_DE);
                    PrefData.remove(CustomLayoutActivity.this, PrefData.G2_DE);
                }
                setData();
                finishmethod();
            }

        });
        subscribe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if (PrefData.getBooleanPrefs(CustomLayoutActivity.this, Constant.SKU)) { //need to remove not
                    String A0 = Spin_A0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.AO_EN, A0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.AO_IT, A0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.AO_SP, A0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.AO_DE, A0.toLowerCase());
                    }

                    String A1 = Spin_A1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A1_EN, A1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A1_IT, A1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A1_SP, A1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A1_DE, A1.toLowerCase());
                    }

                    String A2 = Spin_A2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A2_EN, A2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A2_IT, A2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A2_SP, A2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A2_DE, A2.toLowerCase());
                    }

                    String A3 = Spin_A3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A3_EN, A3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A3_IT, A3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A3_SP, A3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.A3_DE, A3.toLowerCase());
                    }

                    String B0 = Spin_B0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B0_EN, B0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B0_IT, B0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B0_SP, B0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B0_DE, B0.toLowerCase());
                    }

                    String B1 = Spin_B1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B1_EN, B1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B1_IT, B1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B1_SP, B1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B1_DE, B1.toLowerCase());
                    }

                    String B2 = Spin_B2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B2_EN, B2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B2_IT, B2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B2_SP, B2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B2_DE, B2.toLowerCase());
                    }

                    String B3 = Spin_B3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B3_EN, B3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B3_IT, B3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B3_SP, B3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.B3_DE, B3.toLowerCase());
                    }

                    String C0 = Spin_C0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C0_EN, C0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C0_IT, C0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C0_SP, C0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C0_DE, C0.toLowerCase());
                    }

                    String C1 = Spin_C1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C1_EN, C1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C1_IT, C1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C1_SP, C1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C1_DE, C1.toLowerCase());
                    }

                    String C2 = Spin_C2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C2_EN, C2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C2_IT, C2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C2_SP, C2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C2_DE, C2.toLowerCase());
                    }

                    String C3 = Spin_C3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C3_EN, C3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C3_IT, C3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C3_SP, C3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.C3_DE, C3.toLowerCase());
                    }

                    String D0 = Spin_D0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D0_EN, D0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D0_IT, D0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D0_SP, D0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D0_DE, D0.toLowerCase());
                    }

                    String D1 = Spin_D1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D1_EN, D1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D1_IT, D1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D1_SP, D1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D1_DE, D1.toLowerCase());
                    }


                    String D3 = Spin_D3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D3_EN, D3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D3_IT, D3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D3_SP, D3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.D3_DE, D3.toLowerCase());
                    }

                    String E0 = Spin_E0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E0_EN, E0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E0_IT, E0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E0_SP, E0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E0_DE, E0.toLowerCase());
                    }

                    String E1 = Spin_E1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E1_EN, E1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E1_IT, E1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E1_SP, E1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E1_DE, E1.toLowerCase());
                    }

                    String E2 = Spin_E2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E2_EN, E2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E2_IT, E2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E2_SP, E2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E2_DE, E2.toLowerCase());
                    }

                    String E3 = Spin_E3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E3_EN, E3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E3_IT, E3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E3_SP, E3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.E3_DE, E3.toLowerCase());
                    }

                    String F0 = Spin_F0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F0_EN, F0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F0_IT, F0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F0_SP, F0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F0_DE, F0.toLowerCase());
                    }

                    String F1 = Spin_F1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F1_EN, F1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F1_IT, F1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F1_SP, F1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F1_DE, F1.toLowerCase());
                    }

                    String F2 = Spin_F2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F2_EN, F2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F2_IT, F2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F2_SP, F2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F2_DE, F2.toLowerCase());
                    }

                    String F3 = Spin_F3.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F3_EN, F3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F3_IT, F3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F3_SP, F3.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.F3_DE, F3.toLowerCase());
                    }

                    String G0 = Spin_G0.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G0_EN, G0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G0_IT, G0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G0_SP, G0.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G0_DE, G0.toLowerCase());
                    }


                    String G1 = Spin_G1.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G1_EN, G1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G1_IT, G1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G1_SP, G1.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G1_DE, G1.toLowerCase());
                    }

                    String G2 = Spin_G2.getSelectedItem().toString();
                    if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ENGLISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G2_EN, G2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G2_IT, G2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G2_SP, G2.toLowerCase());
                    } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
                        PrefData.setStringPrefs(CustomLayoutActivity.this, PrefData.G2_DE, G2.toLowerCase());
                    }

                    finishmethod();

                //} else { showFreeSubscriptionAlert();}
            }
        });

    }

    private void openPopupDialog(final ArrayList<String> list,final String charcter) {
        final Dialog dialog = new Dialog(CustomLayoutActivity.this);
        dialog.setContentView(R.layout.popup_dialog);
        RecyclerView rv=(RecyclerView) dialog.findViewById(R.id.popup_recycler);
        rv.setLayoutManager(new LinearLayoutManager(CustomLayoutActivity.this));
        final PopUpAdapter adapter= new PopUpAdapter(CustomLayoutActivity.this,list);
        rv.setAdapter(adapter);
        TextView ok = dialog.findViewById(R.id.ok);
        TextView reset = dialog.findViewById(R.id.reset);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(charcter){
                    case PrefData.a:
                        ArrayList<String>a= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.a,a);
                        break;
                    case PrefData.c:
                        ArrayList<String>c= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.c,c);
                        break;
                    case PrefData.d:
                        ArrayList<String>d= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.d,d);
                        break;
                    case PrefData.e:
                        ArrayList<String>e= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.e,e);
                        break;
                    case PrefData.g:
                        ArrayList<String>g= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.g,g);
                        break;
                    case PrefData.h:
                        ArrayList<String>h= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.h,h);
                        break;
                    case PrefData.i:
                        ArrayList<String>i= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.i,i);
                        break;
                    case PrefData.k:
                        ArrayList<String>k= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.k,k);
                        break;
                    case PrefData.l:
                        ArrayList<String>l= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.l,l);
                        break;
                    case PrefData.n:
                        ArrayList<String>n= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.n,n);
                        break;
                    case PrefData.o:
                        ArrayList<String>o= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.o,o);
                        break;
                    case PrefData.r:
                        ArrayList<String>r= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.r,r);
                        break;
                    case PrefData.s:
                        ArrayList<String>s= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.s,s);
                        break;
                    case PrefData.t:
                        ArrayList<String>t= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.t,t);
                        break;
                    case PrefData.u:
                        ArrayList<String>u= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.u,u);
                        break;
                    case PrefData.y:
                        ArrayList<String>y= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.y,y);
                        break;
                    case PrefData.z:
                        ArrayList<String>z= adapter.getList();
                        PrefData.setArrayListPref(CustomLayoutActivity.this,PrefData.z,z);
                        break;
                }

                popupupdate();
                dialog.dismiss();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch(charcter){
                    case PrefData.a:
                        ArrayList<String> a1= new ArrayList<String>(Arrays.asList(a));
                        adapter.setList(a1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.c:
                        ArrayList<String> c1= new ArrayList<String>(Arrays.asList(c));
                        adapter.setList(c1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.d:
                        ArrayList<String> d1= new ArrayList<String>(Arrays.asList(d));
                        adapter.setList(d1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.e:
                        ArrayList<String> e1= new ArrayList<String>(Arrays.asList(e));
                        adapter.setList(e1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.g:
                        ArrayList<String> g1= new ArrayList<String>(Arrays.asList(g));
                        adapter.setList(g1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.h:
                        ArrayList<String> h1= new ArrayList<String>(Arrays.asList(h));
                        adapter.setList(h1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.i:
                        ArrayList<String> i1= new ArrayList<String>(Arrays.asList(i));
                        adapter.setList(i1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.k:
                        ArrayList<String> k1= new ArrayList<String>(Arrays.asList(k));
                        adapter.setList(k1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.l:
                        ArrayList<String> l1= new ArrayList<String>(Arrays.asList(l));
                        adapter.setList(l1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.n:
                        ArrayList<String> n1= new ArrayList<String>(Arrays.asList(n));
                        adapter.setList(n1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.o:
                        ArrayList<String> o1= new ArrayList<String>(Arrays.asList(o));
                        adapter.setList(o1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.r:
                        ArrayList<String> r1= new ArrayList<String>(Arrays.asList(r));
                        adapter.setList(r1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.s:
                        ArrayList<String> s1= new ArrayList<String>(Arrays.asList(s));
                        adapter.setList(s1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.t:
                        ArrayList<String> t1= new ArrayList<String>(Arrays.asList(t));
                        adapter.setList(t1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.u:
                        ArrayList<String> u1= new ArrayList<String>(Arrays.asList(u));
                        adapter.setList(u1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.y:
                        ArrayList<String> y1= new ArrayList<String>(Arrays.asList(y));
                        adapter.setList(y1);
                        adapter.notifyDataSetChanged();
                        break;
                    case PrefData.z:
                        ArrayList<String> z1= new ArrayList<String>(Arrays.asList(z));
                        adapter.setList(z1);
                        adapter.notifyDataSetChanged();
                        break;
                }
                //popupupdate();
            }
        });
        dialog.show();
    }

    private void popupupdate(){
        if (PrefData.getBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMPOPUP)) {
            PrefData.setBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMPOPUP, false);
        } else {
            PrefData.setBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMPOPUP, true);
        }

    }


    private void finishmethod() {
        if (PrefData.getBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMLAYOUT)) {
            PrefData.setBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMLAYOUT, false);
        } else {
            PrefData.setBooleanPrefs(CustomLayoutActivity.this, PrefData.KEY_KEYBOARD_LAYOUT_CUSTOMLAYOUT, true);
        }
        finish();
    }

    private void initGloble() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        SpannableString spannableString = new SpannableString(actionBar.getTitle());
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(spannableString);
        main_txt = findViewById(R.id.main_txt);
        currentKeyboardLayout = PrefData.getIntPrefs(this, PrefData.KEY_KEYBOARD_LAYOUT_I,
                PrefData.VAL_LAYOUT_ENGLISH);
        //e,u,i,o,a,s,c,n,r,t,w,y,z,d,g,h,j,k,l

        //a,c,d,e,g,h,i,j,k,l,o,r,s,t,u,w,y,z
        
        a = new String[]{"æ", "à", "ã", "å", "á", "â", "ä", "ª", "ā", "ă", "ą"};
        c = new String[]{"ć", "č", "ç", "ċ", "ĉ"};
        d = new String[]{"ð", "đ", "ď"};
        e = new String[]{"ē", "è", "ê", "ë", "é", "ę", "ė", "ě"};
        g = new String[]{"ġ", "ğ", "ĝ", "ģ"};
        h = new String[]{"ħ", "ĥ"};
        i = new String[]{"ï", "ì", "ī", "î", "í", "į", "ĩ"};
        //j = new String[]{"ĵ"};
        k = new String[]{"ĸ", "ķ"};
        l = new String[]{"ļ", "ĺ", "ľ", "ŀ", "ł"};
        n = new String[]{"ń", "ñ", "ņ", "ŋ", "ň", "ŉ"};
        o = new String[]{"õ", "ò", "ó", "ø", "ō", "ö", "ô", "œ", "º", "ő"};
        r = new String[]{"ŕ", "ř", "ŗ"};
        s = new String[]{"ŝ", "ß", "š", "ş", "ś", "ș"};
        t = new String[]{"ŧ", "ť", "ț", "ţ"};
        u = new String[]{"ü", "ù", "ú", "ů", "û", "ū", "ŭ", "ũ", "ų", "ű", "µ"};
       // w = new String[]{"ŵ"};
        y = new String[]{"ý", "ŷ", "ÿ"};
        z = new String[]{"ź", "ż", "ž"};
        

        if (currentKeyboardLayout == PrefData.VAL_LAYOUT_ITALIAN) {
            main_txt.setText(R.string.italian);
            array1 = new String[]{"<u>K</u>", "V", "B", "X", "Q", "<u>D</u>", "<u>R</u>", "P", "<u>U</u>", "<u>E</u>", "<u>A</u>", "<u>S</u>", "<u>H</u>", "<u>I</u>", "<u>T</u>", "<u>C</u>", "<u>L</u>", "<u>O</u>", "<u>N</u>", "W", "F", "<u>G</u>", "M", "J", "<u>Y</u>", "<u>Z</u>"};
            array = new String[]{"K", "V", "B", "X", "Q", "D", "R", "P", "U", "E", "A", "S", "H", "I", "T", "C", "L", "O", "N", "W", "F", "G", "M", "J", "Y", "Z"};
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_SPANISH) {
            main_txt.setText(R.string.spanish);
            array1 = new String[]{"<u>G</u>", "B", "F", "X", "Q", "<u>R</u>", "<u>L</u>", "P", "<u>U</u>" , "<u>O</u>", "<u>A</u>", "M", "<u>H</u>", "<u>I</u>", "<u>S</u>", "<u>C</u>", "<u>Y</u>", "<u>E</u>", "<u>T</u>", "W", "V", "<u>D</u>", "<u>N</u>", "<u>K</u>", "J", "<u>Z</u>"};
            array = new String[]{"G", "B", "F", "X", "Q", "R", "L", "P", "U" , "O", "A", "M", "H", "I", "S", "C", "Y", "E", "T", "W", "V", "D", "N", "K", "J", "Z"};
        } else if (currentKeyboardLayout == PrefData.VAL_LAYOUT_GERMAN) {
            main_txt.setText(R.string.german);
            array1 = new String[]{"Q", "<u>Y</u>", "P", "X", "<u>Z</u>", "<u>G</u>", "<u>R</u>", "B", "<u>U</u>", "<u>N</u>", "<u>E</u>", "M", "<u>H</u>", "<u>I</u>", "<u>D</u>", "<u>C</u>", "<u>S</u>", "<u>A</u>", "W", "<u>K</u>", "<u>L</u>", "<u>T</u>", "<u>O</u>", "J", "F", "V"};
            array = new String[]{"Q", "Y", "P", "X", "Z", "G", "R", "B", "U", "N", "E", "M", "H", "I", "D", "C", "S", "A", "W", "K", "L", "T", "O", "J", "F", "V"};
        } else {
            main_txt.setText(R.string.english);
            array1 = new String[]{"J", "<u>Z</u>", "B", "X", "Q", "F", "<u>R</u>", "P", "<u>U</u>", "<u>O</u>", "<u>E</u>", "<u>L</u>", "W", "<u>H</u>", "<u>A</u>", "<u>I</u>", "<u>T</u>", "<u>S</u>", "<u>D</u>", "<u>C</u>", "<u>N</u>", "<u>Y</u>", "M", "<u>K</u>", "<u>G</u>", "V"};
            array = new String[]{"J", "Z", "B", "X", "Q", "F", "R", "P", "U", "O", "E", "L", "W", "H", "A", "I", "T", "S", "D", "C", "N", "Y", "M", "K", "G", "V"};
        }

        reset = findViewById(R.id.reset);
        subscribe = findViewById(R.id.subscribe);


        Text_A0 = findViewById(R.id.Text_A0);
        Text_A0.setText(Html.fromHtml(array1[0]));
        Text_A1 = findViewById(R.id.Text_A1);
        Text_A1.setText(Html.fromHtml(array1[1]));
        Text_A2 = findViewById(R.id.Text_A2);
        Text_A2.setText(Html.fromHtml(array1[2]));
        Text_A3 = findViewById(R.id.Text_A3);
        Text_A3.setText(Html.fromHtml(array1[3]));
        Text_B0 = findViewById(R.id.Text_B0);
        Text_B0.setText(Html.fromHtml(array1[4]));
        Text_B1 = findViewById(R.id.Text_B1);
        Text_B1.setText(Html.fromHtml(array1[5]));
        Text_B2 = findViewById(R.id.Text_B2);
        Text_B2.setText(Html.fromHtml(array1[6]));
        Text_B3 = findViewById(R.id.Text_B3);
        Text_B3.setText(Html.fromHtml(array1[7]));
        Text_C0 = findViewById(R.id.Text_C0);
        Text_C0.setText(Html.fromHtml(array1[8]));
        Text_C1 = findViewById(R.id.Text_C1);
        Text_C1.setText(Html.fromHtml(array1[9]));
        Text_C2 = findViewById(R.id.Text_C2);
        Text_C2.setText(Html.fromHtml(array1[10]));
        Text_C3 = findViewById(R.id.Text_C3);
        Text_C3.setText(Html.fromHtml(array1[11]));
        Text_D0 = findViewById(R.id.Text_D0);
        Text_D0.setText(Html.fromHtml(array1[12]));
        Text_D1 = findViewById(R.id.Text_D1);
        Text_D1.setText(Html.fromHtml(array1[13]));
        Text_D3 = findViewById(R.id.Text_D3);
        Text_D3.setText(Html.fromHtml(array1[14]));
        Text_E0 = findViewById(R.id.Text_E0);
        Text_E0.setText(Html.fromHtml(array1[15]));
        Text_E1 = findViewById(R.id.Text_E1);
        Text_E1.setText(Html.fromHtml(array1[16]));
        Text_E2 = findViewById(R.id.Text_E2);
        Text_E2.setText(Html.fromHtml(array1[17]));
        Text_E3 = findViewById(R.id.Text_E3);
        Text_E3.setText(Html.fromHtml(array1[18]));
        Text_F0 = findViewById(R.id.Text_F0);
        Text_F0.setText(Html.fromHtml(array1[19]));
        Text_F1 = findViewById(R.id.Text_F1);
        Text_F1.setText(Html.fromHtml(array1[20]));
        Text_F2 = findViewById(R.id.Text_F2);
        Text_F2.setText(Html.fromHtml(array1[21]));
        Text_F3 = findViewById(R.id.Text_F3);
        Text_F3.setText(Html.fromHtml(array1[22]));
        Text_G0 = findViewById(R.id.Text_G0);
        Text_G0.setText(Html.fromHtml(array1[23]));
        Text_G1 = findViewById(R.id.Text_G1);
        Text_G1.setText(Html.fromHtml(array1[24]));
        Text_G2 = findViewById(R.id.Text_G2);
        Text_G2.setText(Html.fromHtml(array1[25]));

        Spin_A0 = findViewById(R.id.Spin_A0);
        Spin_A1 = findViewById(R.id.Spin_A1);
        Spin_A2 = findViewById(R.id.Spin_A2);
        Spin_A3 = findViewById(R.id.Spin_A3);
        Spin_B0 = findViewById(R.id.Spin_B0);
        Spin_B1 = findViewById(R.id.SPin_B1);
        Spin_B2 = findViewById(R.id.Spin_B2);
        Spin_B3 = findViewById(R.id.Spin_B3);
        Spin_C0 = findViewById(R.id.Spin_C0);
        Spin_C1 = findViewById(R.id.Spin_C1);
        Spin_C2 = findViewById(R.id.Spin_C2);
        Spin_C3 = findViewById(R.id.Spin_C3);
        Spin_D0 = findViewById(R.id.Spin_D0);
        Spin_D1 = findViewById(R.id.Spin_D1);
        Spin_D3 = findViewById(R.id.Spin_D3);
        Spin_E0 = findViewById(R.id.Spin_E0);
        Spin_E1 = findViewById(R.id.Spin_E1);
        Spin_E2 = findViewById(R.id.Spin_E2);
        Spin_E3 = findViewById(R.id.Spin_E3);
        Spin_F0 = findViewById(R.id.Spin_F0);
        Spin_F1 = findViewById(R.id.Spin_F1);
        Spin_F2 = findViewById(R.id.Spin_F2);
        Spin_F3 = findViewById(R.id.Spin_F3);
        Spin_G0 = findViewById(R.id.Spin_G0);
        Spin_G1 = findViewById(R.id.Spin_G1);
        Spin_G2 = findViewById(R.id.Spin_G2);

        A0 = ArrayAdapter.createFromResource(this, R.array.alphabet, R.layout.text_spinner);
        Spin_A0.setAdapter(A0);
        Spin_A1.setAdapter(A0);
        Spin_A2.setAdapter(A0);
        Spin_A3.setAdapter(A0);
        Spin_B0.setAdapter(A0);
        Spin_B1.setAdapter(A0);
        Spin_B2.setAdapter(A0);
        Spin_B3.setAdapter(A0);
        Spin_C0.setAdapter(A0);
        Spin_C1.setAdapter(A0);
        Spin_C2.setAdapter(A0);
        Spin_C3.setAdapter(A0);
        Spin_D0.setAdapter(A0);
        Spin_D1.setAdapter(A0);
        Spin_D3.setAdapter(A0);
        Spin_E0.setAdapter(A0);
        Spin_E1.setAdapter(A0);
        Spin_E2.setAdapter(A0);
        Spin_E3.setAdapter(A0);
        Spin_F0.setAdapter(A0);
        Spin_F1.setAdapter(A0);
        Spin_F2.setAdapter(A0);
        Spin_F3.setAdapter(A0);
        Spin_G0.setAdapter(A0);
        Spin_G1.setAdapter(A0);
        Spin_G2.setAdapter(A0);

        setData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.theme_market_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_info:
                showLayoutInfoDialog();
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showLayoutInfoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        SpannableString spannableString = new SpannableString(getString(R.string.layout_info));
        spannableString.setSpan(new TypefaceSpan(this, getString(R.string.font_dosis_regular)), 0, spannableString.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        builder.setMessage(spannableString)
                .setPositiveButton(R.string.cancel, null)
                .create().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}