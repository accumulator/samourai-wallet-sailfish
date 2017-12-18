package com.samourai.wallet;

import android.content.res.Configuration;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
//import android.util.Log;

import com.samourai.wallet.R;
import com.samourai.wallet.util.AppUtil;
import com.samourai.wallet.util.TimeOutUtil;

public class SettingsActivity extends PreferenceActivity	{

    private AppCompatDelegate mDelegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getDelegate().installViewFactory();
        getDelegate().onCreate(savedInstanceState);

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_root);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Preference prefsPref = (Preference) findPreference("prefs");
        prefsPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "prefs");
                startActivity(intent);
                return true;
            }
        });

        Preference txsPref = (Preference) findPreference("txs");
        txsPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "txs");
                startActivity(intent);
                return true;
            }
        });

        Preference stealthPref = (Preference) findPreference("stealth");
        stealthPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "stealth");
                startActivity(intent);
                return true;
            }
        });

        Preference remotePref = (Preference) findPreference("remote");
        if(!SamouraiWallet.getInstance().hasPassphrase(SettingsActivity.this)) {
            remotePref.setEnabled(false);
        }
        else    {
            remotePref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                public boolean onPreferenceClick(Preference preference) {
                    Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                    intent.putExtra("branch", "remote");
                    startActivity(intent);
                    return true;
                }
            });
        }

        Preference walletPref = (Preference) findPreference("wallet");
        walletPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "wallet");
                startActivity(intent);
                return true;
            }
        });

        Preference networkingPref = (Preference) findPreference("networking");
        networkingPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "networking");
                startActivity(intent);
                return true;
            }
        });

        Preference troubleshootPref = (Preference) findPreference("troubleshoot");
        troubleshootPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "troubleshoot");
                startActivity(intent);
                return true;
            }
        });

        Preference otherPref = (Preference) findPreference("other");
        otherPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(SettingsActivity.this, SettingsActivity2.class);
                intent.putExtra("branch", "other");
                startActivity(intent);
                return true;
            }
        });

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        getDelegate().onPostCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AppUtil.getInstance(SettingsActivity.this).setIsInForeground(true);

        AppUtil.getInstance(SettingsActivity.this).checkTimeOut();

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == android.R.id.home) {
            finish();
        }
        else {
            ;
        }

        return super.onOptionsItemSelected(item);
    }

    //region AppCompat Delegate
    private AppCompatDelegate getDelegate() {
        if (mDelegate == null) {
            mDelegate = AppCompatDelegate.create(this, null);
        }
        return mDelegate;
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        getDelegate().setSupportActionBar(toolbar);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        getDelegate().setContentView(layoutResID);
    }

    @Override
    public void setContentView(View view) {
        getDelegate().setContentView(view);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().setContentView(view, params);
    }

    @Override
    public void addContentView(View view, ViewGroup.LayoutParams params) {
        getDelegate().addContentView(view, params);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        getDelegate().setTitle(title);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getDelegate().onConfigurationChanged(newConfig);
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }
    //endregion

}
