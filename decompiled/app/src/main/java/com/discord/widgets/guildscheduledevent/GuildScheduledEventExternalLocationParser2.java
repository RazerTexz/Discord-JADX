package com.discord.widgets.guildscheduledevent;

import com.discord.simpleast.core.node.Node;
import com.discord.simpleast.core.parser.Parser;
import com.discord.utilities.textprocessing.MessageParseState;
import com.discord.utilities.textprocessing.MessageRenderContext;
import com.discord.utilities.textprocessing.Rules;
import kotlin.jvm.functions.Function0;
import p007b.p008a.p050t.p052b.p054b.SimpleMarkdownRules5;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventExternalLocationParser$Companion$PARSER$2, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventExternalLocationParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventExternalLocationParser2 extends Lambda implements Function0<Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState>> {
    public static final GuildScheduledEventExternalLocationParser2 INSTANCE = new GuildScheduledEventExternalLocationParser2();

    public GuildScheduledEventExternalLocationParser2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> invoke() {
        Parser<MessageRenderContext, Node<MessageRenderContext>, MessageParseState> parser = new Parser<>(false, 1, null);
        parser.addRule(Rules.INSTANCE.createUrlRule());
        parser.addRule(SimpleMarkdownRules5.f1988h.m374d());
        return parser;
    }
}
