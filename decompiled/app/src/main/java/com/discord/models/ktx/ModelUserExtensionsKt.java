package com.discord.models.ktx;

import androidx.core.app.Person;
import com.discord.models.user.User;
import d0.z.d.m;

/* compiled from: ModelUserExtensions.kt */
/* loaded from: classes.dex */
public final class ModelUserExtensionsKt {
    public static final Person toPerson(User user) {
        m.checkNotNullParameter(user, "$this$toPerson");
        Person personBuild = new Person.Builder().setName(user.getUsername()).setKey(String.valueOf(user.getId())).setBot(user.isBot()).build();
        m.checkNotNullExpressionValue(personBuild, "Person.Builder()\n       …t(isBot)\n        .build()");
        return personBuild;
    }
}
