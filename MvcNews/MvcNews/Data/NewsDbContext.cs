using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using MvcNews.Models;

namespace MvcNews.Data
{
	public class NewsDbContext : DbContext
	{
		public NewsDbContext(DbContextOptions<NewsDbContext> options) : base(options) { }

		public DbSet<NewsItem> News { get; set; }
	}
}
