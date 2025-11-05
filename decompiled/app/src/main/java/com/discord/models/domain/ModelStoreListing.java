package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelStoreListing.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelStoreListing {
    private final long id;
    private final ModelSku sku;

    /* compiled from: ModelStoreListing.kt */
    public static final class Parser implements Model.Parser<ModelStoreListing> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelStoreListing parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelStoreListing parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            reader.nextObject(new ModelStoreListing$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef));
            ModelSku modelSku = (ModelSku) ref$ObjectRefC0.element;
            m.checkNotNull(modelSku);
            Long l = (Long) ref$ObjectRef.element;
            return new ModelStoreListing(modelSku, l != null ? l.longValue() : 0L);
        }
    }

    public ModelStoreListing(ModelSku modelSku, long j) {
        m.checkNotNullParameter(modelSku, "sku");
        this.sku = modelSku;
        this.id = j;
    }

    public static /* synthetic */ ModelStoreListing copy$default(ModelStoreListing modelStoreListing, ModelSku modelSku, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            modelSku = modelStoreListing.sku;
        }
        if ((i & 2) != 0) {
            j = modelStoreListing.id;
        }
        return modelStoreListing.copy(modelSku, j);
    }

    /* renamed from: component1, reason: from getter */
    public final ModelSku getSku() {
        return this.sku;
    }

    /* renamed from: component2, reason: from getter */
    public final long getId() {
        return this.id;
    }

    public final ModelStoreListing copy(ModelSku sku, long id2) {
        m.checkNotNullParameter(sku, "sku");
        return new ModelStoreListing(sku, id2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreListing)) {
            return false;
        }
        ModelStoreListing modelStoreListing = (ModelStoreListing) other;
        return m.areEqual(this.sku, modelStoreListing.sku) && this.id == modelStoreListing.id;
    }

    public final long getId() {
        return this.id;
    }

    public final ModelSku getSku() {
        return this.sku;
    }

    public int hashCode() {
        ModelSku modelSku = this.sku;
        int iHashCode = modelSku != null ? modelSku.hashCode() : 0;
        long j = this.id;
        return (iHashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        StringBuilder sbU = a.U("ModelStoreListing(sku=");
        sbU.append(this.sku);
        sbU.append(", id=");
        return a.C(sbU, this.id, ")");
    }
}
