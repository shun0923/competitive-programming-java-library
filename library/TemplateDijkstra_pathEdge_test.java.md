---
data:
  _extendedDependsOn:
  - icon: ':question:'
    path: library/AbstractGraph.java
    title: library/AbstractGraph.java
  - icon: ':question:'
    path: library/PathRestoration.java
    title: library/PathRestoration.java
  - icon: ':question:'
    path: library/Solver.java
    title: library/Solver.java
  - icon: ':x:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/shortest_path
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 420, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n  File \"/opt/hostedtoolcache/Python/3.10.7/x64/lib/python3.10/subprocess.py\"\
    , line 524, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.PathRestoration;\nimport library.TemplateDijkstra;\n\npublic class\
    \ TemplateDijkstra_pathEdge_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new TemplateDijkstra_pathEdge_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tint s = ni();\n\t\t\
    int t = ni();\n\t\tArrayTemplateGraph<Long> g = new ArrayTemplateGraph<>(n, true);\n\
    \t\tfor(int i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tTemplateDijkstra<Long>\
    \ djk = new TemplateDijkstra<>(() -> 0l, (dist, cost) -> dist + cost,\n\t\t\t\
    Comparator.comparing((ele) -> ele));\n\t\tLong x = djk.dist(g, s, true).get(t);\n\
    \t\tif(x == null) prtln(-1);\n\t\telse {\n\t\t\tint path[] = djk.path(s, t);\n\
    \t\t\tprtln(x, path.length - 1);\n\t\t\tfor(int i = 0; i < path.length - 1; i\
    \ ++) prtln(path[i], path[i + 1]);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  - library/TemplateDijkstra.java
  isVerificationFile: true
  path: library/TemplateDijkstra_pathEdge_test.java
  requiredBy: []
  timestamp: '2022-10-04 10:50:43+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TemplateDijkstra_pathEdge_test.java
layout: document
redirect_from:
- /verify/library/TemplateDijkstra_pathEdge_test.java
- /verify/library/TemplateDijkstra_pathEdge_test.java.html
title: library/TemplateDijkstra_pathEdge_test.java
---
