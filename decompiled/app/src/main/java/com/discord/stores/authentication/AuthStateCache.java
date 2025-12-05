package com.discord.stores.authentication;

import android.content.SharedPreferences;
import com.discord.models.authentication.AuthState;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: AuthStateCache.kt */
/* loaded from: classes2.dex */
public final class AuthStateCache {
    private final Gson gson;
    private final SharedPreferences prefs;

    /* compiled from: AuthStateCache.kt */
    public static final class Keys {
        public static final String AUTH_STATE = "STORE_AUTH_STATE";
        public static final Keys INSTANCE = new Keys();
        public static final String TOKEN = "STORE_AUTHED_TOKEN";

        private Keys() {
        }
    }

    public AuthStateCache(SharedPreferences sharedPreferences) {
        Intrinsics3.checkNotNullParameter(sharedPreferences, "prefs");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    public final void cacheAuthState(AuthState authState) throws JsonIOException {
        if (authState == null) {
            SharedPreferences.Editor editorEdit = this.prefs.edit();
            Intrinsics3.checkNotNullExpressionValue(editorEdit, "editor");
            editorEdit.remove(Keys.AUTH_STATE);
            editorEdit.remove(Keys.TOKEN);
            editorEdit.apply();
            return;
        }
        String strM9209m = this.gson.m9209m(authState);
        SharedPreferences.Editor editorEdit2 = this.prefs.edit();
        Intrinsics3.checkNotNullExpressionValue(editorEdit2, "editor");
        editorEdit2.putString(Keys.AUTH_STATE, strM9209m);
        editorEdit2.putString(Keys.TOKEN, authState.getToken());
        editorEdit2.apply();
    }

    public final AuthState getCachedAuthState() {
        String string = this.prefs.getString(Keys.AUTH_STATE, null);
        if (string != null) {
            try {
                return (AuthState) C3404f.m4203E1(AuthState.class).cast(this.gson.m9203g(string, AuthState.class));
            } catch (Exception unused) {
            }
        }
        String string2 = this.prefs.getString(Keys.TOKEN, null);
        if (string2 != null) {
            return AuthState.INSTANCE.from(string2, Sets5.emptySet());
        }
        return null;
    }
}
