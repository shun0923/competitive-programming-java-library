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
  - icon: ':question:'
    path: library/TemplateDijkstra.java
    title: library/TemplateDijkstra.java
  _extendedRequiredBy: []
  _extendedVerifiedWith: []
  _isVerificationFailed: true
  _pathExtension: java
  _verificationStatusIcon: ':x:'
  attributes:
    PROBLEM: https://judge.yosupo.jp/problem/shortest_path
  bundledCode: "Traceback (most recent call last):\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/documentation/build.py\"\
    , line 71, in _render_source_code_stat\n    bundled_code = language.bundle(stat.path,\
    \ basedir=basedir, options={'include_paths': [basedir]}).decode()\n          \
    \         ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/site-packages/onlinejudge_verify/languages/user_defined.py\"\
    , line 71, in bundle\n    return subprocess.check_output(shlex.split(command))\n\
    \           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 466, in check_output\n    return run(*popenargs, stdout=PIPE, timeout=timeout,\
    \ check=True,\n           ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\
    \  File \"/opt/hostedtoolcache/Python/3.11.2/x64/lib/python3.11/subprocess.py\"\
    , line 571, in run\n    raise CalledProcessError(retcode, process.args,\nsubprocess.CalledProcessError:\
    \ Command '['false']' returned non-zero exit status 1.\n"
  code: "// verification-helper: PROBLEM https://judge.yosupo.jp/problem/shortest_path\n\
    \npackage library;\n\nimport java.util.*;\nimport library.Solver;\nimport library.AbstractGraph;\n\
    import library.PathRestoration;\nimport library.TemplateDijkstra;\n\npublic class\
    \ TemplateDijkstra_pathEdge_test extends Solver {\n\tpublic static void main(final\
    \ String[] args) { main(args, new TemplateDijkstra_pathEdge_test()); }\n\n\tpublic\
    \ void solve() {\n\t\tint n = ni();\n\t\tint m = ni();\n\t\tint s = ni();\n\t\t\
    int t = ni();\n\t\tvar g = new TemplateListGraph<Long>(n, true);\n\t\tfor(int\
    \ i = 0; i < m; i ++) g.add(ni(), ni(), nl());\n\t\tTemplateDijkstra<Long> djk\
    \ = new TemplateDijkstra<>(() -> 0l, (dist, cost) -> dist + cost,\n\t\t\tComparator.comparing((ele)\
    \ -> ele));\n\t\tint prv[] = new int[n];\n\t\tLong x = djk.dist(g, s, prv).get(t);\n\
    \t\tif(x == null) prtln(-1);\n\t\telse {\n\t\t\tint path[] = PathRestoration.path(prv,\
    \ s, t);\n\t\t\tprtln(x, path.length - 1);\n\t\t\tfor(int i = 0; i < path.length\
    \ - 1; i ++) prtln(path[i], path[i + 1]);\n\t\t}\n\t}\n}"
  dependsOn:
  - library/Solver.java
  - library/AbstractGraph.java
  - library/PathRestoration.java
  - library/TemplateDijkstra.java
  isVerificationFile: true
  path: library/TemplateDijkstra_path_test.java
  requiredBy: []
  timestamp: '2023-03-24 01:50:05+09:00'
  verificationStatus: TEST_WRONG_ANSWER
  verifiedWith: []
documentation_of: library/TemplateDijkstra_path_test.java
layout: document
redirect_from:
- /verify/library/TemplateDijkstra_path_test.java
- /verify/library/TemplateDijkstra_path_test.java.html
title: library/TemplateDijkstra_path_test.java
---
