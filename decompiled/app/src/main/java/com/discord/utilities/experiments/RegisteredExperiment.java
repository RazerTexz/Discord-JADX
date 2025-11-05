package com.discord.utilities.experiments;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import java.util.List;

/* compiled from: ExperimentRegistry.kt */
/* loaded from: classes2.dex */
public final /* data */ class RegisteredExperiment {
    private final List<String> buckets;
    private final boolean cacheExperiment;
    private final String name;
    private final String readableName;
    private final Type type;

    /* compiled from: ExperimentRegistry.kt */
    public enum Type {
        GUILD,
        USER
    }

    public RegisteredExperiment(String str, String str2, Type type, List<String> list, boolean z2) {
        m.checkNotNullParameter(str, "readableName");
        m.checkNotNullParameter(str2, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(list, "buckets");
        this.readableName = str;
        this.name = str2;
        this.type = type;
        this.buckets = list;
        this.cacheExperiment = z2;
    }

    public static /* synthetic */ RegisteredExperiment copy$default(RegisteredExperiment registeredExperiment, String str, String str2, Type type, List list, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = registeredExperiment.readableName;
        }
        if ((i & 2) != 0) {
            str2 = registeredExperiment.name;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            type = registeredExperiment.type;
        }
        Type type2 = type;
        if ((i & 8) != 0) {
            list = registeredExperiment.buckets;
        }
        List list2 = list;
        if ((i & 16) != 0) {
            z2 = registeredExperiment.cacheExperiment;
        }
        return registeredExperiment.copy(str, str3, type2, list2, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getReadableName() {
        return this.readableName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final List<String> component4() {
        return this.buckets;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final RegisteredExperiment copy(String readableName, String name, Type type, List<String> buckets, boolean cacheExperiment) {
        m.checkNotNullParameter(readableName, "readableName");
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(type, "type");
        m.checkNotNullParameter(buckets, "buckets");
        return new RegisteredExperiment(readableName, name, type, buckets, cacheExperiment);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisteredExperiment)) {
            return false;
        }
        RegisteredExperiment registeredExperiment = (RegisteredExperiment) other;
        return m.areEqual(this.readableName, registeredExperiment.readableName) && m.areEqual(this.name, registeredExperiment.name) && m.areEqual(this.type, registeredExperiment.type) && m.areEqual(this.buckets, registeredExperiment.buckets) && this.cacheExperiment == registeredExperiment.cacheExperiment;
    }

    public final List<String> getBuckets() {
        return this.buckets;
    }

    public final boolean getCacheExperiment() {
        return this.cacheExperiment;
    }

    public final String getName() {
        return this.name;
    }

    public final String getReadableName() {
        return this.readableName;
    }

    public final Type getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.readableName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Type type = this.type;
        int iHashCode3 = (iHashCode2 + (type != null ? type.hashCode() : 0)) * 31;
        List<String> list = this.buckets;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z2 = this.cacheExperiment;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        StringBuilder sbU = a.U("RegisteredExperiment(readableName=");
        sbU.append(this.readableName);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", type=");
        sbU.append(this.type);
        sbU.append(", buckets=");
        sbU.append(this.buckets);
        sbU.append(", cacheExperiment=");
        return a.O(sbU, this.cacheExperiment, ")");
    }
}
