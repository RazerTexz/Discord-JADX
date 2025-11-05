package com.esotericsoftware.kryo.serializers;

import b.e.a.a;

/* loaded from: classes.dex */
public class TaggedFieldSerializerConfig extends FieldSerializerConfig {
    private boolean skipUnknownTags = false;

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    public /* bridge */ /* synthetic */ FieldSerializerConfig clone() {
        return clone();
    }

    @Deprecated
    public boolean isIgnoreUnknownTags() {
        return false;
    }

    public boolean isSkipUnknownTags() {
        return this.skipUnknownTags;
    }

    @Deprecated
    public void setIgnoreUnknownTags(boolean z2) {
    }

    public void setSkipUnknownTags(boolean z2) {
        this.skipUnknownTags = z2;
        a.C0064a c0064a = a.a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    /* renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo77clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    public TaggedFieldSerializerConfig clone() {
        return (TaggedFieldSerializerConfig) super.clone();
    }
}
