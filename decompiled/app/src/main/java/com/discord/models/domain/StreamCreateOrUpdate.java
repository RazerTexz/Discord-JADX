package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
/* loaded from: classes.dex */
public final /* data */ class StreamCreateOrUpdate {
    private final boolean paused;
    private final String rtcServerId;
    private final String streamKey;
    private final List<Long> viewerIds;

    /* compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<StreamCreateOrUpdate> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ StreamCreateOrUpdate parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public StreamCreateOrUpdate parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
            ref$BooleanRef.element = false;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new StreamCreateOrUpdate$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$BooleanRef, ref$ObjectRef2));
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                m.throwUninitializedPropertyAccessException("streamKey");
            }
            String str = (String) t;
            String str2 = (String) ref$ObjectRef.element;
            boolean z2 = ref$BooleanRef.element;
            List listEmptyList = (List) ref$ObjectRef2.element;
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
            return new StreamCreateOrUpdate(str, str2, z2, listEmptyList);
        }
    }

    public StreamCreateOrUpdate(String str, String str2, boolean z2, List<Long> list) {
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(list, "viewerIds");
        this.streamKey = str;
        this.rtcServerId = str2;
        this.paused = z2;
        this.viewerIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StreamCreateOrUpdate copy$default(StreamCreateOrUpdate streamCreateOrUpdate, String str, String str2, boolean z2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamCreateOrUpdate.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = streamCreateOrUpdate.rtcServerId;
        }
        if ((i & 4) != 0) {
            z2 = streamCreateOrUpdate.paused;
        }
        if ((i & 8) != 0) {
            list = streamCreateOrUpdate.viewerIds;
        }
        return streamCreateOrUpdate.copy(str, str2, z2, list);
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

    public final StreamCreateOrUpdate copy(String streamKey, String rtcServerId, boolean paused, List<Long> viewerIds) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(viewerIds, "viewerIds");
        return new StreamCreateOrUpdate(streamKey, rtcServerId, paused, viewerIds);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamCreateOrUpdate)) {
            return false;
        }
        StreamCreateOrUpdate streamCreateOrUpdate = (StreamCreateOrUpdate) other;
        return m.areEqual(this.streamKey, streamCreateOrUpdate.streamKey) && m.areEqual(this.rtcServerId, streamCreateOrUpdate.rtcServerId) && this.paused == streamCreateOrUpdate.paused && m.areEqual(this.viewerIds, streamCreateOrUpdate.viewerIds);
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
        StringBuilder sbU = a.U("StreamCreateOrUpdate(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", rtcServerId=");
        sbU.append(this.rtcServerId);
        sbU.append(", paused=");
        sbU.append(this.paused);
        sbU.append(", viewerIds=");
        return a.L(sbU, this.viewerIds, ")");
    }
}
