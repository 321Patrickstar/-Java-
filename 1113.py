import networkx as nx
import numpy as np
import csv
import time

# 创建图对象
G = nx.Graph()

# 从CSV文件中读取边信息
with open(r'D:\A-CHAT\oregon1_010407.txt\oregon1_010407.csv', 'r') as csvfile:
    reader = csv.reader(csvfile)
    next(reader)  # 跳过标题行
    for row in reader:
        source_node = int(row[0])  # 假设起始节点在第一列
        target_node = int(row[1])  # 假设目标节点在第二列
        G.add_edge(source_node, target_node)  # 添加边到图中

# 使用NetworkX的pagerank算法计算PageRank
start_time = time.time()
nx_pagerank = nx.pagerank(G, alpha=0.85)
end_time = time.time()
nx_pagerank_time = end_time - start_time

# 获取图的转移矩阵Stochastic_matrix
# 获取网页列表
webpages = list(G.nodes())
Stochastic_matrix = np.zeros((len(webpages), len(webpages)))
for i, page in enumerate(webpages):
    neighbors = list(G.neighbors(page))
    if neighbors:
        for neighbor in neighbors:
            j = webpages.index(neighbor)
            Stochastic_matrix[i, j] = 1 / len(neighbors)

Stochastic_matrix = Stochastic_matrix.T

# 归一化矩阵，确保每列的元素之和等于1
for j in range(len(webpages)):
    col_sum = np.sum(Stochastic_matrix[:, j])
    if col_sum == 0:
        # 如果列和为0，说明没有出链的节点
        Stochastic_matrix[:, j] = 1 / len(webpages)
    else:
        Stochastic_matrix[:, j] /= col_sum


# 自定义PageRank函数
def pagerank(graph, damping_factor=0.85, max_iterations=100, tol=1e-6):
    num_nodes = len(graph)
    rank = np.ones(num_nodes) / num_nodes

    for _ in range(max_iterations):
        new_rank = (1 - damping_factor) / num_nodes + damping_factor * np.dot(Stochastic_matrix, rank)
        if np.linalg.norm(new_rank - rank) < tol:
            # 归一化 PageRank 值
            rank /= rank.sum()
            return rank
        rank = new_rank

    # 归一化 PageRank 值
    rank /= rank.sum()
    return rank


# # 计算自定义PageRank
# adj_matrix = nx.to_numpy_array(G)
# start_time = time.time()
# custom_pagerank = pagerank(adj_matrix)
# end_time = time.time()
# custom_pagerank_time = end_time - start_time
# 计算自定义PageRank
adj_matrix = nx.to_numpy_array(G)
start_time = time.time()
custom_pagerank = pagerank(adj_matrix, max_iterations=100)  # 调整最大迭代次数
end_time = time.time()
custom_pagerank_time = end_time - start_time


# 打印运行时间
print(f"NetworkX PageRank 运行时间: {nx_pagerank_time:.6f} 秒")
print(f"自定义 PageRank 运行时间: {custom_pagerank_time:.6f} 秒")

# 将自定义PageRank结果转换为字典
custom_pagerank_dict = {node: score for node, score in enumerate(custom_pagerank)}

# 创建一个映射字典，将节点标签映射为从0开始的索引
label_to_index = {label: index for index, label in enumerate(nx_pagerank.keys())}

# 创建一个新的字典，以从0开始的索引作为键
new_pagerank_dict = {label_to_index[label]: value for label, value in nx_pagerank.items()}

# 现在，new_pagerank_dict 包含了以从0开始的节点标签的PageRank结果

# 对字典按照PageRank值降序排序
sorted_custom_pagerank = dict(sorted(custom_pagerank_dict.items(), key=lambda item: item[1]))
sorted_new_pagerank = dict(sorted(new_pagerank_dict.items(), key=lambda item: item[1]))

# 比较结果 - 仅比较前一万个节点
for node, rank in sorted_custom_pagerank.items():
    if node in sorted_new_pagerank:
        diff = abs(sorted_new_pagerank[node] - rank)
        print(
            f"Node {node}: NetworkX={sorted_new_pagerank[node]:.6f}, PageRank={rank:.6f}")

networkx_pagerank_values = np.array(list(sorted_new_pagerank.values()))
custom_pagerank_values = np.array(list(sorted_custom_pagerank.values()))

# 计算排序相关系数
correlation_coefficient = np.corrcoef(networkx_pagerank_values, custom_pagerank_values)[0, 1]

print(f"排序相关系数: {correlation_coefficient:.6f}")
# # 将自定义PageRank结果转换为字典
# custom_pagerank_dict = {node: score for node, score in enumerate(custom_pagerank)}
#
# # 创建一个映射字典，将节点标签映射为从0开始的索引
# label_to_index = {label: index for index, label in enumerate(nx_pagerank.keys())}
#
# # 创建一个新的字典，以从0开始的索引作为键
# new_pagerank_dict = {label_to_index[label]: value for label, value in nx_pagerank.items()}
#
# # 现在，new_pagerank_dict 包含了以从0开始的节点标签的PageRank结果
#
# # 比较结果 - 仅比较前一万个节点
# for node in range(10000):
#     if node in custom_pagerank_dict and node in new_pagerank_dict:
#         diff = abs(new_pagerank_dict[node] - custom_pagerank_dict[node])
#         print(
#             f"Node {node}: NetworkX={new_pagerank_dict[node]:.6f}, my={custom_pagerank_dict[node]:.6f}, Difference={diff:.6f}")