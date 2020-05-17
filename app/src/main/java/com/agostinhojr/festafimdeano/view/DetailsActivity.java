package com.agostinhojr.festafimdeano.view;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.agostinhojr.festafimdeano.Constant.FimDeAnoConstants;
import com.agostinhojr.festafimdeano.R;
import com.agostinhojr.festafimdeano.data.SecurityPreferences;

public class DetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private SecurityPreferences mSecurityPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.mSecurityPreferences = new SecurityPreferences(this);

        this.mViewHolder.checkParticipate = findViewById(R.id.check_participate);
        this.mViewHolder.checkParticipate.setOnClickListener(this);
        this.loadDataFromActivity();
    }

    private void loadDataFromActivity() {
        {
            Bundle extras = getIntent().getExtras();
            if (extras != null) {
                String presence = extras.getString(FimDeAnoConstants.PRESENCE_KEY);
                if (presence != null && presence.equals(FimDeAnoConstants.CONFIRMATION_YES)) {
                    this.mViewHolder.checkParticipate.setChecked(true);
                } else {
                    this.mViewHolder.checkParticipate.setChecked(false);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.check_participate) {
            if (this.mViewHolder.checkParticipate.isChecked()) {
                // Salvar participação
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_YES);
            } else {
                // Salva ausencia
                this.mSecurityPreferences.storeString(FimDeAnoConstants.PRESENCE_KEY, FimDeAnoConstants.CONFIRMATION_NO);
            }
        }
    }

    private static class ViewHolder {
        CheckBox checkParticipate;
    }
}
