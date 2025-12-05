package com.discord.api.user;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: UserSurvey.kt */
/* renamed from: com.discord.api.user.UserSurveyFetchResponse, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class UserSurvey3 {
    private final UserSurvey survey;

    /* renamed from: a, reason: from getter */
    public final UserSurvey getSurvey() {
        return this.survey;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof UserSurvey3) && Intrinsics3.areEqual(this.survey, ((UserSurvey3) other).survey);
        }
        return true;
    }

    public int hashCode() {
        UserSurvey userSurvey = this.survey;
        if (userSurvey != null) {
            return userSurvey.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("UserSurveyFetchResponse(survey=");
        sbM833U.append(this.survey);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
