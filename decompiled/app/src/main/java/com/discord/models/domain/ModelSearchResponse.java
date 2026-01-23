package com.discord.models.domain;

import androidx.core.app.FrameMetricsAggregator;
import com.discord.api.channel.Channel;
import com.discord.api.message.Message;
import com.discord.api.thread.ThreadMember;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ModelSearchResponse.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelSearchResponse {
    private final String analyticsId;
    private final Integer documentIndexed;
    private final Integer errorCode;

    /* JADX INFO: renamed from: hits$delegate, reason: from kotlin metadata */
    private final Lazy hits;
    private final List<ThreadMember> members;
    private final String message;
    private final List<List<Message>> messages;
    private final Integer retryAfter;
    private final long retryMillis;
    private final List<Channel> threads;
    private final int totalResults;

    public ModelSearchResponse() {
        this(0, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ModelSearchResponse(int i, List<? extends List<Message>> list, List<Channel> list2, List<? extends ThreadMember> list3, String str, String str2, Integer num, Integer num2, Integer num3) {
        this.totalResults = i;
        this.messages = list;
        this.threads = list2;
        this.members = list3;
        this.analyticsId = str;
        this.message = str2;
        this.errorCode = num;
        this.documentIndexed = num2;
        this.retryAfter = num3;
        this.retryMillis = (num3 != null ? num3.intValue() : 0L) * ((long) 1000);
        this.hits = LazyJVM.lazy(new ModelSearchResponse2(this));
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    private final Integer getRetryAfter() {
        return this.retryAfter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ModelSearchResponse copy$default(ModelSearchResponse modelSearchResponse, int i, List list, List list2, List list3, String str, String str2, Integer num, Integer num2, Integer num3, int i2, Object obj) {
        return modelSearchResponse.copy((i2 & 1) != 0 ? modelSearchResponse.totalResults : i, (i2 & 2) != 0 ? modelSearchResponse.messages : list, (i2 & 4) != 0 ? modelSearchResponse.threads : list2, (i2 & 8) != 0 ? modelSearchResponse.members : list3, (i2 & 16) != 0 ? modelSearchResponse.analyticsId : str, (i2 & 32) != 0 ? modelSearchResponse.message : str2, (i2 & 64) != 0 ? modelSearchResponse.errorCode : num, (i2 & 128) != 0 ? modelSearchResponse.documentIndexed : num2, (i2 & 256) != 0 ? modelSearchResponse.retryAfter : num3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getTotalResults() {
        return this.totalResults;
    }

    public final List<List<Message>> component2() {
        return this.messages;
    }

    public final List<Channel> component3() {
        return this.threads;
    }

    public final List<ThreadMember> component4() {
        return this.members;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Integer getDocumentIndexed() {
        return this.documentIndexed;
    }

    public final ModelSearchResponse copy(int totalResults, List<? extends List<Message>> messages, List<Channel> threads, List<? extends ThreadMember> members, String analyticsId, String message, Integer errorCode, Integer documentIndexed, Integer retryAfter) {
        return new ModelSearchResponse(totalResults, messages, threads, members, analyticsId, message, errorCode, documentIndexed, retryAfter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelSearchResponse)) {
            return false;
        }
        ModelSearchResponse modelSearchResponse = (ModelSearchResponse) other;
        return this.totalResults == modelSearchResponse.totalResults && Intrinsics3.areEqual(this.messages, modelSearchResponse.messages) && Intrinsics3.areEqual(this.threads, modelSearchResponse.threads) && Intrinsics3.areEqual(this.members, modelSearchResponse.members) && Intrinsics3.areEqual(this.analyticsId, modelSearchResponse.analyticsId) && Intrinsics3.areEqual(this.message, modelSearchResponse.message) && Intrinsics3.areEqual(this.errorCode, modelSearchResponse.errorCode) && Intrinsics3.areEqual(this.documentIndexed, modelSearchResponse.documentIndexed) && Intrinsics3.areEqual(this.retryAfter, modelSearchResponse.retryAfter);
    }

    public final String getAnalyticsId() {
        return this.analyticsId;
    }

    public final Integer getDocumentIndexed() {
        return this.documentIndexed;
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final List<Message> getHits() {
        return (List) this.hits.getValue();
    }

    public final List<ThreadMember> getMembers() {
        return this.members;
    }

    public final String getMessage() {
        return this.message;
    }

    public final List<List<Message>> getMessages() {
        return this.messages;
    }

    public final long getRetryMillis() {
        return this.retryMillis;
    }

    public final List<Channel> getThreads() {
        return this.threads;
    }

    public final int getTotalResults() {
        return this.totalResults;
    }

    public int hashCode() {
        int i = this.totalResults * 31;
        List<List<Message>> list = this.messages;
        int iHashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<Channel> list2 = this.threads;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ThreadMember> list3 = this.members;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.analyticsId;
        int iHashCode4 = (iHashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.message;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.errorCode;
        int iHashCode6 = (iHashCode5 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.documentIndexed;
        int iHashCode7 = (iHashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.retryAfter;
        return iHashCode7 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelSearchResponse(totalResults=");
        sbM833U.append(this.totalResults);
        sbM833U.append(", messages=");
        sbM833U.append(this.messages);
        sbM833U.append(", threads=");
        sbM833U.append(this.threads);
        sbM833U.append(", members=");
        sbM833U.append(this.members);
        sbM833U.append(", analyticsId=");
        sbM833U.append(this.analyticsId);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", errorCode=");
        sbM833U.append(this.errorCode);
        sbM833U.append(", documentIndexed=");
        sbM833U.append(this.documentIndexed);
        sbM833U.append(", retryAfter=");
        return outline.m818F(sbM833U, this.retryAfter, ")");
    }

    public /* synthetic */ ModelSearchResponse(int i, List list, List list2, List list3, String str, String str2, Integer num, Integer num2, Integer num3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : list, (i2 & 4) != 0 ? null : list2, (i2 & 8) != 0 ? null : list3, (i2 & 16) != 0 ? null : str, (i2 & 32) != 0 ? null : str2, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : num2, (i2 & 256) == 0 ? num3 : null);
    }
}
