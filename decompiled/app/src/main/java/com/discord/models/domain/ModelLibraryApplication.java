package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.api.application.Application;
import com.discord.models.domain.Model;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelLibraryApplication.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelLibraryApplication {
    private final Application application;
    private final long branchId;
    private final String createdAt;
    private final int flags;
    private final long skuId;

    /* compiled from: ModelLibraryApplication.kt */
    public static final class Parser implements Model.Parser<ModelLibraryApplication> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelLibraryApplication parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelLibraryApplication parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
            ref$ObjectRef4.element = null;
            reader.nextObject(new ModelLibraryApplication$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2, ref$ObjectRef3, ref$ObjectRef4));
            Application application = (Application) ref$ObjectRefC0.element;
            m.checkNotNull(application);
            String str = (String) ref$ObjectRef.element;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            Long l = (Long) ref$ObjectRef2.element;
            long jLongValue = l != null ? l.longValue() : 0L;
            Integer num = (Integer) ref$ObjectRef3.element;
            int iIntValue = num != null ? num.intValue() : 0;
            Long l2 = (Long) ref$ObjectRef4.element;
            return new ModelLibraryApplication(application, str2, jLongValue, iIntValue, l2 != null ? l2.longValue() : 0L);
        }
    }

    public ModelLibraryApplication(Application application, String str, long j, int i, long j2) {
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(str, "createdAt");
        this.application = application;
        this.createdAt = str;
        this.skuId = j;
        this.flags = i;
        this.branchId = j2;
    }

    public static /* synthetic */ ModelLibraryApplication copy$default(ModelLibraryApplication modelLibraryApplication, Application application, String str, long j, int i, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            application = modelLibraryApplication.application;
        }
        if ((i2 & 2) != 0) {
            str = modelLibraryApplication.createdAt;
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            j = modelLibraryApplication.skuId;
        }
        long j3 = j;
        if ((i2 & 8) != 0) {
            i = modelLibraryApplication.flags;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            j2 = modelLibraryApplication.branchId;
        }
        return modelLibraryApplication.copy(application, str2, j3, i3, j2);
    }

    /* renamed from: component1, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCreatedAt() {
        return this.createdAt;
    }

    /* renamed from: component3, reason: from getter */
    public final long getSkuId() {
        return this.skuId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: component5, reason: from getter */
    public final long getBranchId() {
        return this.branchId;
    }

    public final ModelLibraryApplication copy(Application application, String createdAt, long skuId, int flags, long branchId) {
        m.checkNotNullParameter(application, "application");
        m.checkNotNullParameter(createdAt, "createdAt");
        return new ModelLibraryApplication(application, createdAt, skuId, flags, branchId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelLibraryApplication)) {
            return false;
        }
        ModelLibraryApplication modelLibraryApplication = (ModelLibraryApplication) other;
        return m.areEqual(this.application, modelLibraryApplication.application) && m.areEqual(this.createdAt, modelLibraryApplication.createdAt) && this.skuId == modelLibraryApplication.skuId && this.flags == modelLibraryApplication.flags && this.branchId == modelLibraryApplication.branchId;
    }

    public final Application getApplication() {
        return this.application;
    }

    public final long getBranchId() {
        return this.branchId;
    }

    public final String getCreatedAt() {
        return this.createdAt;
    }

    public final int getFlags() {
        return this.flags;
    }

    public final long getSkuId() {
        return this.skuId;
    }

    public int hashCode() {
        Application application = this.application;
        int iHashCode = (application != null ? application.hashCode() : 0) * 31;
        String str = this.createdAt;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        long j = this.skuId;
        int i = (((iHashCode2 + ((int) (j ^ (j >>> 32)))) * 31) + this.flags) * 31;
        long j2 = this.branchId;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelLibraryApplication(application=");
        sbU.append(this.application);
        sbU.append(", createdAt=");
        sbU.append(this.createdAt);
        sbU.append(", skuId=");
        sbU.append(this.skuId);
        sbU.append(", flags=");
        sbU.append(this.flags);
        sbU.append(", branchId=");
        return a.C(sbU, this.branchId, ")");
    }
}
