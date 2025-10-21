package com.discord.analytics.generated.events;

import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBase2;
import com.discord.api.science.AnalyticsSchema;

/* compiled from: TrackHubStudentPromptClicked.kt */
/* loaded from: classes.dex */
public final class TrackHubStudentPromptClicked implements AnalyticsSchema, TrackBase2 {
    private final transient String analyticsSchemaTypeName = "hub_student_prompt_clicked";
    private TrackBase trackBase;

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }
}
