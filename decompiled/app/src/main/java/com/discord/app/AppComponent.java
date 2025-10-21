package com.discord.app;

import rx.subjects.Subject;

/* compiled from: AppComponent.kt */
/* loaded from: classes.dex */
public interface AppComponent {
    Subject<Void, Void> getUnsubscribeSignal();
}
