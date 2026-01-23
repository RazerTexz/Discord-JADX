package com.fasterxml.jackson.core;

import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p198b.JsonLocation;

/* JADX INFO: loaded from: classes3.dex */
public class JsonGenerationException extends JsonProcessingException {
    private static final long serialVersionUID = 123;

    /* JADX INFO: renamed from: j */
    public transient JsonGenerator f19660j;

    public JsonGenerationException(String str, JsonGenerator jsonGenerator) {
        super(str, (JsonLocation) null);
        this.f19660j = jsonGenerator;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* JADX INFO: renamed from: c */
    public Object mo8737c() {
        return this.f19660j;
    }
}
