package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.functions.Action1;

/* compiled from: ModelPhoneVerificationToken.kt */
/* renamed from: com.discord.models.domain.ModelPhoneVerificationToken$Update$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelPhoneVerificationToken2<T> implements Action1<String> {
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $token;

    public ModelPhoneVerificationToken2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$token = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != 110541305 || !str.equals("token")) {
            this.$reader.skipValue();
            return;
        }
        Ref$ObjectRef ref$ObjectRef = this.$token;
        T t = (T) this.$reader.nextString("");
        Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
        ref$ObjectRef.element = t;
    }
}
