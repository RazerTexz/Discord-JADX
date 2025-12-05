package com.discord.models.domain;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelMemberVerificationForm.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelMemberVerificationForm {
    private final List<FormField> formFields;
    private final String version;

    /* compiled from: ModelMemberVerificationForm.kt */
    public static final /* data */ class FormField {
        private final List<String> choices;
        private final String fieldType;
        private final String label;
        private final boolean required;
        private Object response;
        private final List<String> values;

        /* compiled from: ModelMemberVerificationForm.kt */
        public static final class Parser implements Model.Parser<FormField> {
            public static final Parser INSTANCE = new Parser();

            private Parser() {
            }

            @Override // com.discord.models.domain.Model.Parser
            public /* bridge */ /* synthetic */ FormField parse(Model.JsonReader jsonReader) {
                return parse(jsonReader);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.discord.models.domain.Model.Parser
            public FormField parse(Model.JsonReader reader) throws IOException {
                Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
                ref$ObjectRefM844c0.element = null;
                Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
                ref$ObjectRef.element = null;
                Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                ref$BooleanRef.element = false;
                Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
                ref$ObjectRef2.element = null;
                Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
                ref$ObjectRef3.element = null;
                Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                ref$ObjectRef4.element = null;
                reader.nextObject(new ModelMemberVerificationForm2(ref$ObjectRefM844c0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
                T t = ref$ObjectRefM844c0.element;
                if (t == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("fieldType");
                }
                String str = (String) t;
                T t2 = ref$ObjectRef.element;
                if (t2 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("label");
                }
                String str2 = (String) t2;
                boolean z2 = ref$BooleanRef.element;
                T t3 = ref$ObjectRef2.element;
                if (t3 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("values");
                }
                List list = (List) t3;
                T t4 = ref$ObjectRef3.element;
                if (t4 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("choices");
                }
                List list2 = (List) t4;
                T t5 = ref$ObjectRef4.element;
                if (t5 == 0) {
                    Intrinsics3.throwUninitializedPropertyAccessException("response");
                }
                return new FormField(str, str2, z2, list, list2, t5);
            }
        }

        public FormField(String str, String str2, boolean z2, List<String> list, List<String> list2, Object obj) {
            Intrinsics3.checkNotNullParameter(str, "fieldType");
            Intrinsics3.checkNotNullParameter(str2, "label");
            Intrinsics3.checkNotNullParameter(list, "values");
            Intrinsics3.checkNotNullParameter(list2, "choices");
            Intrinsics3.checkNotNullParameter(obj, "response");
            this.fieldType = str;
            this.label = str2;
            this.required = z2;
            this.values = list;
            this.choices = list2;
            this.response = obj;
        }

        public static /* synthetic */ FormField copy$default(FormField formField, String str, String str2, boolean z2, List list, List list2, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                str = formField.fieldType;
            }
            if ((i & 2) != 0) {
                str2 = formField.label;
            }
            String str3 = str2;
            if ((i & 4) != 0) {
                z2 = formField.required;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                list = formField.values;
            }
            List list3 = list;
            if ((i & 16) != 0) {
                list2 = formField.choices;
            }
            List list4 = list2;
            if ((i & 32) != 0) {
                obj = formField.response;
            }
            return formField.copy(str, str3, z3, list3, list4, obj);
        }

        /* renamed from: component1, reason: from getter */
        public final String getFieldType() {
            return this.fieldType;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLabel() {
            return this.label;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getRequired() {
            return this.required;
        }

        public final List<String> component4() {
            return this.values;
        }

        public final List<String> component5() {
            return this.choices;
        }

        /* renamed from: component6, reason: from getter */
        public final Object getResponse() {
            return this.response;
        }

        public final FormField copy(String fieldType, String label, boolean required, List<String> values, List<String> choices, Object response) {
            Intrinsics3.checkNotNullParameter(fieldType, "fieldType");
            Intrinsics3.checkNotNullParameter(label, "label");
            Intrinsics3.checkNotNullParameter(values, "values");
            Intrinsics3.checkNotNullParameter(choices, "choices");
            Intrinsics3.checkNotNullParameter(response, "response");
            return new FormField(fieldType, label, required, values, choices, response);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FormField)) {
                return false;
            }
            FormField formField = (FormField) other;
            return Intrinsics3.areEqual(this.fieldType, formField.fieldType) && Intrinsics3.areEqual(this.label, formField.label) && this.required == formField.required && Intrinsics3.areEqual(this.values, formField.values) && Intrinsics3.areEqual(this.choices, formField.choices) && Intrinsics3.areEqual(this.response, formField.response);
        }

        public final List<String> getChoices() {
            return this.choices;
        }

        public final String getFieldType() {
            return this.fieldType;
        }

        public final String getLabel() {
            return this.label;
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final MemberVerificationFieldType getMemberVerificationFieldType() {
            String str = this.fieldType;
            switch (str.hashCode()) {
                case -708597224:
                    if (str.equals("TEXT_INPUT")) {
                        return MemberVerificationFieldType.TEXT_INPUT;
                    }
                    break;
                case 79712615:
                    if (str.equals("TERMS")) {
                        return MemberVerificationFieldType.TERMS;
                    }
                    break;
                case 440916302:
                    if (str.equals("PARAGRAPH")) {
                        return MemberVerificationFieldType.PARAGRAPH;
                    }
                    break;
                case 1121961648:
                    if (str.equals("MULTIPLE_CHOICE")) {
                        return MemberVerificationFieldType.MULTIPLE_CHOICE;
                    }
                    break;
            }
            return MemberVerificationFieldType.UNKNOWN;
        }

        public final boolean getRequired() {
            return this.required;
        }

        public final Object getResponse() {
            return this.response;
        }

        public final List<String> getValues() {
            return this.values;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.fieldType;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.label;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.required;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            List<String> list = this.values;
            int iHashCode3 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
            List<String> list2 = this.choices;
            int iHashCode4 = (iHashCode3 + (list2 != null ? list2.hashCode() : 0)) * 31;
            Object obj = this.response;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }

        public final void setResponse(Object obj) {
            Intrinsics3.checkNotNullParameter(obj, "<set-?>");
            this.response = obj;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("FormField(fieldType=");
            sbM833U.append(this.fieldType);
            sbM833U.append(", label=");
            sbM833U.append(this.label);
            sbM833U.append(", required=");
            sbM833U.append(this.required);
            sbM833U.append(", values=");
            sbM833U.append(this.values);
            sbM833U.append(", choices=");
            sbM833U.append(this.choices);
            sbM833U.append(", response=");
            sbM833U.append(this.response);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: ModelMemberVerificationForm.kt */
    public enum MemberVerificationFieldType {
        UNKNOWN,
        TERMS,
        TEXT_INPUT,
        PARAGRAPH,
        MULTIPLE_CHOICE
    }

    /* compiled from: ModelMemberVerificationForm.kt */
    public static final class Parser implements Model.Parser<ModelMemberVerificationForm> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelMemberVerificationForm parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelMemberVerificationForm parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextObject(new ModelMemberVerificationForm3(ref$ObjectRefM844c0, reader, ref$ObjectRef));
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("version");
            }
            String str = (String) t;
            T t2 = ref$ObjectRef.element;
            if (t2 == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("formFields");
            }
            return new ModelMemberVerificationForm(str, (List) t2);
        }
    }

    public ModelMemberVerificationForm(String str, List<FormField> list) {
        Intrinsics3.checkNotNullParameter(str, "version");
        Intrinsics3.checkNotNullParameter(list, "formFields");
        this.version = str;
        this.formFields = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelMemberVerificationForm copy$default(ModelMemberVerificationForm modelMemberVerificationForm, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelMemberVerificationForm.version;
        }
        if ((i & 2) != 0) {
            list = modelMemberVerificationForm.formFields;
        }
        return modelMemberVerificationForm.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    public final List<FormField> component2() {
        return this.formFields;
    }

    public final ModelMemberVerificationForm copy(String version, List<FormField> formFields) {
        Intrinsics3.checkNotNullParameter(version, "version");
        Intrinsics3.checkNotNullParameter(formFields, "formFields");
        return new ModelMemberVerificationForm(version, formFields);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelMemberVerificationForm)) {
            return false;
        }
        ModelMemberVerificationForm modelMemberVerificationForm = (ModelMemberVerificationForm) other;
        return Intrinsics3.areEqual(this.version, modelMemberVerificationForm.version) && Intrinsics3.areEqual(this.formFields, modelMemberVerificationForm.formFields);
    }

    public final List<FormField> getFormFields() {
        return this.formFields;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.version;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<FormField> list = this.formFields;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public final boolean isFormOutdated() {
        List<FormField> list = this.formFields;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((FormField) it.next()).getMemberVerificationFieldType() == MemberVerificationFieldType.UNKNOWN) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelMemberVerificationForm(version=");
        sbM833U.append(this.version);
        sbM833U.append(", formFields=");
        return outline.m824L(sbM833U, this.formFields, ")");
    }
}
