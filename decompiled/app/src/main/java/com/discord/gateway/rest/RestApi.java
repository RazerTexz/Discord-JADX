package com.discord.gateway.rest;

import com.discord.models.domain.ModelGateway;
import p630i0.p636f0.GET;
import p658rx.Observable;

/* compiled from: RestApi.kt */
/* loaded from: classes.dex */
public interface RestApi {
    @GET("gateway")
    Observable<ModelGateway> getGateway();
}
