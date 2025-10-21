package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
/* renamed from: com.discord.models.domain.StreamCreateOrUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream3 {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    /* compiled from: ModelApplicationStream.kt */
    /* renamed from: com.discord.models.domain.StreamCreateOrUpdate$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream3> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream3 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream3 parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream4(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            String str = (String) t;
            String str2 = (String) ref$ObjectRef.element;
            boolean z2 = ref$BooleanRef.element;
            List listEmptyList = (List) ref$ObjectRef2.element;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            return new ModelApplicationStream3(str, str2, z2, listEmptyList);
        }
    }

    public ModelApplicationStream3(String str, String str2, boolean z2, List<Long> list) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelApplicationStream3 copy$default(ModelApplicationStream3 modelApplicationStream3, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream3.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream3.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = modelApplicationStream3.paused;
        }
        if ((i & 8) != 0) {
            list = modelApplicationStream3.viewerIds;
        }
        return modelApplicationStream3.copy(str, str2, z2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPaused() {
        return this.paused;
    }

    public final List<Long> component4() {
        return this.viewerIds;
    }

    public final ModelApplicationStream3 copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(viewerIds, "viewerIds");
        return new ModelApplicationStream3(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream3)) {
            return false;
        }
        ModelApplicationStream3 modelApplicationStream3 = (ModelApplicationStream3) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream3.streamKey) && Intrinsics3.areEqual(this.rtcServerId, modelApplicationStream3.rtcServerId) && this.paused == modelApplicationStream3.paused && Intrinsics3.areEqual(this.viewerIds, modelApplicationStream3.viewerIds);
    }

    public final boolean getPaused() {
        return this.paused;
    }

    public final String getRtcServerId() {
        return this.rtcServerId;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final List<Long> getViewerIds() {
        return this.viewerIds;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.rtcServerId;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.paused;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        int i2 = (iHashCode2 + i) * 31;
        List<Long> list = this.viewerIds;
        return i2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamCreateOrUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", rtcServerId=");
        sbU.append(this.rtcServerId);
        sbU.append(", paused=");
        sbU.append(this.paused);
        sbU.append(", viewerIds=");
        return outline.L(sbU, this.viewerIds, ")");
    }
}
