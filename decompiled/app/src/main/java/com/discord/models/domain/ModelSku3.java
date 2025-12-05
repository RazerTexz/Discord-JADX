package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p658rx.functions.Action1;

/* compiled from: ModelSku.kt */
/* renamed from: com.discord.models.domain.ModelSku$Price$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelSku3<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $amount;
    public final /* synthetic */ Ref$ObjectRef $currency;
    public final /* synthetic */ Model.JsonReader $reader;

    public ModelSku3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$amount = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$currency = ref$ObjectRef2;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -1413853096) {
                if (iHashCode == 575402001 && str.equals("currency")) {
                    this.$currency.element = (T) this.$reader.nextStringOrNull();
                    return;
                }
            } else if (str.equals("amount")) {
                this.$amount.element = (T) this.$reader.nextIntOrNull();
                return;
            }
        }
        this.$reader.skipValue();
    }
}
