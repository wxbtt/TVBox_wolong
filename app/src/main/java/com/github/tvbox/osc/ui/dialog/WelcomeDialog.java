package com.github.tvbox.osc.ui.dialog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.github.tvbox.osc.R;
import com.github.tvbox.osc.util.CustomUtil;
import com.github.tvbox.osc.util.HawkConfig;
import com.orhanobut.hawk.Hawk;

import org.jetbrains.annotations.NotNull;

public class WelcomeDialog extends BaseDialog {

    public WelcomeDialog(@NonNull @NotNull Context context) {
        super(context);
        if (!Hawk.get("welcome_dialog", false)){
            setContentView(R.layout.dialog_welcome);

            TextView welcome_message = findViewById(R.id.welcome_message);
            welcome_message.setText("\n"+CustomUtil.getAppMsg());

            Button btnShowVersion = findViewById(R.id.btn_show_version);
            btnShowVersion.setText("我已了解");
            btnShowVersion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Assuming AboutDialog is only used in MainActivity
//                    Toast.makeText(getContext(), "当前版本: 240501", Toast.LENGTH_SHORT).show();
                    System.out.println("APP - 欢迎弹窗");
                    Hawk.put("welcome_dialog", true);
                    dismiss();
                }
            });
        } else {
            System.out.println("APP - 无需弹窗");
        }
    }
}
