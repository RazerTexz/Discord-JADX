package com.discord.gateway.rest;

import com.discord.models.domain.ModelGateway;
import i0.f0.GET;
import rx.Observable;

/* compiled from: RestApi.kt */
/* loaded from: classes.dex */
public interface RestApi {
    @GET("gateway")
    Observable<ModelGateway> getGateway();
}
