package com.fasterxml.jackson.core.exc;

import com.fasterxml.jackson.core.JsonProcessingException;
import p007b.p100d.p104b.p105a.outline;
import p007b.p195g.p196a.p198b.JsonParser;
import p007b.p195g.p196a.p198b.p204t.RequestPayload;

/* loaded from: classes3.dex */
public abstract class StreamReadException extends JsonProcessingException {
    public static final long serialVersionUID = 1;
    public RequestPayload _requestPayload;

    @Override // com.fasterxml.jackson.core.JsonProcessingException
    /* renamed from: c */
    public /* bridge */ /* synthetic */ Object mo8737c() {
        return mo8738d();
    }

    /* renamed from: d */
    public JsonParser mo8738d() {
        return null;
    }

    @Override // com.fasterxml.jackson.core.JsonProcessingException, java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (this._requestPayload == null) {
            return message;
        }
        StringBuilder sbM836X = outline.m836X(message, "\nRequest payload : ");
        sbM836X.append(this._requestPayload.toString());
        return sbM836X.toString();
    }
}
