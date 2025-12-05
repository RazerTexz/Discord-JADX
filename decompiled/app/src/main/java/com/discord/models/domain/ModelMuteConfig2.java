package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p658rx.functions.Action1;

/* compiled from: ModelMuteConfig.kt */
/* renamed from: com.discord.models.domain.ModelMuteConfig$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelMuteConfig2<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $endTime;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelMuteConfig2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$endTime = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str == null || str.hashCode() != 1725551537 || !str.equals("end_time")) {
            this.$reader.skipValue();
        } else {
            this.$endTime.element = (T) this.$reader.nextStringOrNull();
        }
    }
}
