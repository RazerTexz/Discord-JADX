package com.discord.utilities.search.query.parsing;

import android.content.Context;
import com.discord.simpleast.core.parser.ParseSpec;
import com.discord.simpleast.core.parser.Parser;
import com.discord.simpleast.core.parser.Rule;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.UserNode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: QueryParser.kt */
/* renamed from: com.discord.utilities.search.query.parsing.QueryParser$Companion$getUserRule$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class QueryParser9 extends Rule<Context, QueryNode, Object> {
    public final /* synthetic */ Pattern $fromUserPattern;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QueryParser9(Pattern pattern, Pattern pattern2) {
        super(pattern2);
        this.$fromUserPattern = pattern;
    }

    @Override // com.discord.simpleast.core.parser.Rule
    public ParseSpec<Context, Object> parse(Matcher matcher, Parser<Context, ? super QueryNode, Object> parser, Object state) {
        Intrinsics3.checkNotNullParameter(matcher, "matcher");
        Intrinsics3.checkNotNullParameter(parser, "parser");
        String strGroup = matcher.group(1);
        Intrinsics3.checkNotNull(strGroup);
        String strGroup2 = matcher.group(2);
        Intrinsics3.checkNotNull(strGroup2);
        UserNode userNode = new UserNode(strGroup, Integer.parseInt(strGroup2));
        Intrinsics3.checkNotNullParameter(userNode, "node");
        return new ParseSpec<>(userNode, state);
    }
}
