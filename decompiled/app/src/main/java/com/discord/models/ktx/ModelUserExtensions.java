package com.discord.models.ktx;

import androidx.core.app.Person;
import com.discord.models.user.User;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelUserExtensions.kt */
/* renamed from: com.discord.models.ktx.ModelUserExtensionsKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ModelUserExtensions {
    public static final Person toPerson(User user) {
        Intrinsics3.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.isBot()).build();
        Intrinsics3.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
