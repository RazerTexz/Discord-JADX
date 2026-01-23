package com.esotericsoftware.kryo.serializers;

import p007b.p106e.p107a.Log;

/* JADX INFO: loaded from: classes.dex */
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
        Log.a aVar = Log.f3007a;
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    /* JADX INFO: renamed from: clone */
    public /* bridge */ /* synthetic */ Object mo11454clone() throws CloneNotSupportedException {
        return clone();
    }

    @Override // com.esotericsoftware.kryo.serializers.FieldSerializerConfig
    public TaggedFieldSerializerConfig clone() {
        return (TaggedFieldSerializerConfig) super.clone();
    }
}
