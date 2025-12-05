package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelMemberVerificationForm;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: ModelMemberVerificationForm.kt */
/* renamed from: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelMemberVerificationForm3<T> implements Action1<String> {
    public final /* synthetic */ Ref$ObjectRef $formFields;
    public final /* synthetic */ Model.JsonReader $reader;
    public final /* synthetic */ Ref$ObjectRef $version;

    /* compiled from: ModelMemberVerificationForm.kt */
    /* renamed from: com.discord.models.domain.ModelMemberVerificationForm$Parser$parse$1$1 */
    public static final class C55421<T> implements Model.JsonReader.ItemFactory<ModelMemberVerificationForm.FormField> {
        public C55421() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ ModelMemberVerificationForm.FormField get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final ModelMemberVerificationForm.FormField get() {
            return ModelMemberVerificationForm.FormField.Parser.INSTANCE.parse(ModelMemberVerificationForm3.this.$reader);
        }
    }

    public ModelMemberVerificationForm3(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader, Ref$ObjectRef ref$ObjectRef2) {
        this.$version = ref$ObjectRef;
        this.$reader = jsonReader;
        this.$formFields = ref$ObjectRef2;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) throws IOException {
        call2(str);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) throws IOException {
        if (str != null) {
            int iHashCode = str.hashCode();
            if (iHashCode != -708425068) {
                if (iHashCode == 351608024 && str.equals("version")) {
                    Ref$ObjectRef ref$ObjectRef = this.$version;
                    T t = (T) this.$reader.nextString("");
                    Intrinsics3.checkNotNullExpressionValue(t, "reader.nextString(\"\")");
                    ref$ObjectRef.element = t;
                    return;
                }
            } else if (str.equals("form_fields")) {
                Ref$ObjectRef ref$ObjectRef2 = this.$formFields;
                T t2 = (T) this.$reader.nextList(new C55421());
                Intrinsics3.checkNotNullExpressionValue(t2, "reader.nextList { FormField.Parser.parse(reader) }");
                ref$ObjectRef2.element = t2;
                return;
            }
        }
        this.$reader.skipValue();
    }
}
